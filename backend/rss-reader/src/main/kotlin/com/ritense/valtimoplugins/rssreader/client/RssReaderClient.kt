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

package com.ritense.valtimoplugins.rssreader.client

import com.ritense.valtimoplugins.rssreader.domain.RssReaderResponse
import org.springframework.http.MediaType
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import java.net.URI

class RssReaderClient(
    private val restClientBuilder: RestClient.Builder
) {
    fun readRss(baseUri: URI): RssReaderResponse {
        val xml = restClientBuilder
            .clone()
            .messageConverters { converters ->
                converters.add(MappingJackson2XmlHttpMessageConverter())
            }
            .build()
            .get()
            .uri(baseUri)
            .accept(MediaType.APPLICATION_RSS_XML)
            .retrieve()
            .body<RssReaderResponse>()!!
        return xml
    }
}