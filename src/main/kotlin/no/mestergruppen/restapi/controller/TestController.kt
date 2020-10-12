package no.mestergruppen.restapi.controller

import org.springframework.http.MediaType.TEXT_PLAIN_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/v1/hello", produces = [TEXT_PLAIN_VALUE])
class TestController {
    @GetMapping
    fun test(@RequestParam name: String): String {
        return "Hello $name, the time is ${LocalDateTime.now()}"
    }
}