/*
 *  Copyright 2015-2025 Ritense BV, the Netherlands.
 *
 *  Licensed under EUPL, Version 1.2 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" basis,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.ritense.valtimoplugins.valuemapper.plugin

import com.ritense.plugin.annotation.Plugin
import com.ritense.plugin.annotation.PluginAction
import com.ritense.plugin.annotation.PluginActionProperty
import com.ritense.plugin.annotation.PluginCategory
import com.ritense.processlink.domain.ActivityTypeWithEventName.SERVICE_TASK_START
import io.github.oshai.kotlinlogging.KotlinLogging
import org.camunda.bpm.engine.delegate.DelegateExecution

@PluginCategory("mapping")
@Plugin(
    key = "value-mapper",
    title = "Value Mapper plugin",
    description = "Plugin for mapping and transforming values from a source JSON document to a target JSON document"
)
open class ValueMapperPlugin(
    private val valueMapper: ValueMapper

) {

    /**
     *  @param execution Execution reference of current process in scope.
     *  @param mappingDefinitionId the definition id (filename without `.valuemapping.json` suffix)
     */
    @PluginAction(
        key = "process-mapping-instructions",
        title = "Process mapping instructions",
        description = "Process mapping instructions from value mapping definition on a JSON document.",
        activityTypes = [SERVICE_TASK_START]
    )
    fun processMapping(
        execution: DelegateExecution,
        @PluginActionProperty definitionKey: String
    )
    {
        val businessKey = execution.businessKey

        logger.info{"Processing mapping definition ${definitionKey} for process definition ${execution.processDefinitionId} with businesskey $businessKey"}

        valueMapper.applyToDocument(definitionKey, businessKey)
    }

    companion object {
        private val logger = KotlinLogging.logger { }
    }

}
