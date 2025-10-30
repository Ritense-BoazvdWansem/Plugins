package com.ritense.valtimoplugins.rssreader.service

import com.ritense.valtimoplugins.rssreader.domain.RssItem
import com.ritense.valtimoplugins.rssreader.domain.RssUpdateListener
import java.net.URI

class RssUpdateNotifier {
    private val listeners = mutableListOf<RssUpdateListener>()

    fun register(listener: RssUpdateListener) = listeners.add(listener)
    fun unregister(listener: RssUpdateListener) = listeners.remove(listener)

    fun notify(url: URI, newItems: List<RssItem>) {
        listeners.forEach { it.onNewItem(url, newItems) }
    }
}
