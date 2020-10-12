package no.mestergruppen.restapi.controller

import io.swagger.annotations.ApiParam
import no.mestergruppen.restapi.data.NobbProduct
import no.mestergruppen.restapi.data.NobbProductRepository
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/test", produces = [APPLICATION_JSON_VALUE])
class TestController(
        private val nobbProductRepository: NobbProductRepository
) {
    @GetMapping("product")
    fun getProduct(@RequestParam @ApiParam(example = "48613952") nobbNr: Int): NobbProduct {
        return nobbProductRepository.findById(nobbNr).get()
    }
}