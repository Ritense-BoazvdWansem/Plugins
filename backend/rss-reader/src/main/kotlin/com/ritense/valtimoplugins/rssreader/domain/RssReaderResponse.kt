/*
 * Copyright 2015-2025 Ritense BV, the Netherlands.
 *
 * Licensed under EUPL, Version 1.2 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ritense.valtimoplugins.rssreader.domain

import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "rss")
data class RssReaderResponse(
    @JacksonXmlProperty(localName = "channel")
    val channel: Channel
) {
    data class Channel(
        @JacksonXmlProperty(localName = "title")
        val title: String? = null,

        @JacksonXmlProperty(localName = "link")
        val link: String? = null,

        @JacksonXmlProperty(localName = "description")
        val description: String? = null,

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "item")
        val items: List<Item>? = emptyList()
    )

    data class Item(
        @JacksonXmlProperty(localName = "title")
        val title: String? = null,

        @JacksonXmlProperty(localName = "link")
        val link: String? = null,

        @JacksonXmlProperty(localName = "pubDate")
        val pubDate: String? = null,

        @JacksonXmlProperty(localName = "description")
        val description: String? = null
    )
}