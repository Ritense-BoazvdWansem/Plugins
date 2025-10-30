package com.ritense.valtimoplugins.rssreader.service

import com.ritense.valtimoplugins.rssreader.client.RssReaderClient
import org.springframework.scheduling.annotation.Scheduled
import java.net.URI

class RssFeedPoller(
    private val rssReaderClient: RssReaderClient,
    private val notifier: RssUpdateNotifier
) {
    private val lastSeenItems = mutableMapOf<URI, Set<String>>()

    @Scheduled(fixedDelay = 60_000)
    fun pollFeeds() {
        lastSeenItems.keys.forEach { url ->
            val response = rssReaderClient.readRss(url)
            val items = response.channel.items ?: emptyList()

            val newItems = items.filter { it.link !in (lastSeenItems[url] ?: emptySet()) }

            if (newItems.isNotEmpty()) {
                notifier.notify(url, newItems.map {
                    com.ritense.valtimoplugins.rssreader.domain.RssItem(
                        title = it.title,
                        link = it.link,
                        description = it.description,
                        pubDate = it.pubDate
                    )
                })
                lastSeenItems[url] = items.mapNotNull { it.link }.toSet()
            }
        }
    }

    fun addFeed(url: URI) {
        lastSeenItems[url] = emptySet()
    }
}
