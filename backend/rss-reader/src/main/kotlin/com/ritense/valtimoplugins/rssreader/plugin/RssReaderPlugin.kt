/*
 * Copyright 2015-2024 Ritense BV, the Netherlands.
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

package com.ritense.valtimoplugins.rssreader.plugin

import com.ritense.plugin.annotation.Plugin
import com.ritense.plugin.annotation.PluginAction
import com.ritense.plugin.annotation.PluginActionProperty
import com.ritense.processlink.domain.ActivityTypeWithEventName
import com.ritense.valtimoplugins.rssreader.client.RssReaderClient
import org.camunda.bpm.engine.delegate.DelegateExecution
import java.net.URI

@Plugin(
    key = "rss-reader",
    title = "RSS Reader",
    description = "Plugin for reading RSS feeds."
)
open class RssReaderPlugin(
    private val rssReaderClient: RssReaderClient,
) {
    @PluginAction(
        key = "read-rss-feed",
        title = "Read RSS Feed",
        description = "Reads from RSS Feed",
        activityTypes = [ActivityTypeWithEventName.SERVICE_TASK_START]
    )
    open fun readRssFeed(
        execution: DelegateExecution,
        @PluginActionProperty url: URI,
    ) {
        rssReaderClient.readRss(url)
    }
}