package no.mestergruppen.restapi.controller

import io.swagger.annotations.ApiParam
import no.mestergruppen.restapi.data.NobbProduct
import no.mestergruppen.restapi.repositories.NobbProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/v1/test", produces = [APPLICATION_JSON_VALUE])
class TestController(
        private val nobbProductRepository: NobbProductRepository
) {
    @GetMapping("product")
    fun getProduct(@RequestParam @ApiParam(example = "48613952") nobbNr: Int):
                    ResponseEntity<NobbProduct> {
        val findProduct = nobbProductRepository.findById(nobbNr).get()
        if (findProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
        return ResponseEntity.ok(findProduct)
    }

    @GetMapping("products")
    fun getAllProducts(): ResponseEntity<List<NobbProduct>>{
        val products = nobbProductRepository.findAll().toList()
        if (products.isEmpty()){
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.ok(products)
    }

    @PostMapping("add")
    fun addProduct(@RequestBody product: NobbProduct): ResponseEntity<NobbProduct>{
        val addProduct = nobbProductRepository.save(product)
        return ResponseEntity.status(HttpStatus.CREATED).body(addProduct)
    }

    @PutMapping("edit")
    fun editProduct(@RequestParam nobbNr: Int,
                    @RequestBody product: NobbProduct): ResponseEntity<NobbProduct>{
        val time: LocalDateTime = LocalDateTime.now()
        val updateProduct = nobbProductRepository.findById(nobbNr).get()
        return if (updateProduct != null) {
            updateProduct.apply {
                varetekst = product.varetekst
                langVaretekst = product.langVaretekst
                prisEnhet = product.prisEnhet
                updated = time
                vareType = product.vareType
            }
            val update = nobbProductRepository.save(updateProduct)
            ResponseEntity.status(HttpStatus.CREATED).body(update)
        } else{
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }

    }

    @DeleteMapping("delete")
    fun deleteProduct(@RequestParam nobbNr: Int): ResponseEntity<NobbProduct>{
        val deleteProduct = nobbProductRepository.findById(nobbNr).get()
        if (deleteProduct == null){
            return ResponseEntity.notFound().build()
        }
        nobbProductRepository.delete(deleteProduct)
        return ResponseEntity.ok(deleteProduct)
    }
}