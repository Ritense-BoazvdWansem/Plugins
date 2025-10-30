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

import {PluginSpecification} from '@valtimo/plugin';
import {RSS_READER_PLUGIN_LOGO_BASE64} from './assets';
import {RssReaderConfigurationComponent} from "./components/rss-reader-configuration/rss-reader-configuration.component";
import {ReadRssFeedConfigurationComponent} from "./components/read-rss-feed/read-rss-feed-configuration.component";

const rssReaderPluginSpecification: PluginSpecification = {
  pluginId: 'rss-reader',
  pluginConfigurationComponent: RssReaderConfigurationComponent,
  pluginLogoBase64: RSS_READER_PLUGIN_LOGO_BASE64,
  functionConfigurationComponents: {
    'read-rss-feed': ReadRssFeedConfigurationComponent
  },
  pluginTranslations: {
    nl: {
      title: 'RSS Reader',
      'read-rss-feed': 'Voeg een RSS feed toe',
      url: 'RSS Feed URL',
      urlTooltip: 'Een URL naar de RSS feed.',
      description: 'Lees RSS van een feed.',
      configurationTitle: 'Configuratienaam',
      configurationTitleTooltip:
        'De naam van de huidige plugin-configuratie. Onder deze naam kan de configuratie in de rest van de applicatie teruggevonden worden.',
    },
    en: {
      title: 'RSS Reader',
      'read-rss-feed': 'Add a RSS feed',
      url: 'RSS Feed URL',
      urlTooltip: 'The URL of the RSS Feed.',
      description: 'Send SMS and E-mail with the NotifyNL service.',
      configurationTitle: 'Configuration name',
      configurationTitleTooltip:
          'The name of the current plugin configuration. Under this name, the configuration can be found in the rest of the application.',
    }
  },
};

export {rssReaderPluginSpecification};
