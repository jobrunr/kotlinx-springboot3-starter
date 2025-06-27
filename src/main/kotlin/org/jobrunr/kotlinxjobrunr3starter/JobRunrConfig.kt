package org.jobrunr.kotlinxjobrunr3starter

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import org.jobrunr.jobs.mappers.JobMapper
import org.jobrunr.kotlin.utils.mapper.KotlinxSerializationJsonMapper
import org.jobrunr.storage.InMemoryStorageProvider
import org.jobrunr.storage.StorageProvider
import org.jobrunr.utils.mapper.JsonMapper
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class JobRunrConfig {

    @Bean
    fun jobMapper(jsonMapper: JsonMapper): JobMapper {
        return JobMapper(jsonMapper)
    }

    // You will also need to create a jobMapper bean that initializes the JobRunr kotlinx serialization mapper
    // We plan on including this in the JobRunr spring boot starter library
    @OptIn(ExperimentalSerializationApi::class, InternalSerializationApi::class)
    @Bean(name = ["jobRunrJsonMapper"])
    @ConditionalOnMissingBean
    fun kotlinxSerializationJsonMapper(): JsonMapper {
        return KotlinxSerializationJsonMapper()
    }

}