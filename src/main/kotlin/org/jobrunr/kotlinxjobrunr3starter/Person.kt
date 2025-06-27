package org.jobrunr.kotlinxjobrunr3starter

import kotlinx.serialization.Serializable

@Serializable
data class Person(val name: String, val age: Int) {
}