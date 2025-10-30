package com.ritense.valtimoplugins.rssreader.domain

import java.net.URI

interface RssUpdateListener {
    fun onNewItem(url: URI, newItems: List<RssItem>)
}

interface RssUpdateNotifier {
    fun notify(url: URI, newItems: List<RssReaderResponse.Item>)
}
