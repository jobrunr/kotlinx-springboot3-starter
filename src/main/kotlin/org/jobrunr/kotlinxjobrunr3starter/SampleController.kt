package org.jobrunr.kotlinxjobrunr3starter

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jobrunr.scheduling.JobScheduler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

    @Autowired
    private lateinit var jobScheduler: JobScheduler

    fun myThing(number: Int) {
        println("$number test")
    }

    @GetMapping("/")
    fun index(@RequestParam name: String): String {
        // a kotlinx serialization test without JobRunr
        val person = Person(name = name, age = 30)
        val json = Json.encodeToString(person)
        println("Hello $json")

        jobScheduler.enqueue {
            println("hi!")
        }

        jobScheduler.enqueue {
            myThing(123)
        }

        return "Hello $json"
    }
}