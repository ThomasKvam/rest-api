package no.mestergruppen.restapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.security.Principal
import java.util.*

@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .ignoredParameterTypes(Principal::class.java)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/v1/.*"))
            .build()
            .apiInfo(apiInfo())
}

private fun apiInfo(): ApiInfo? {
    return ApiInfo(
            "Mestergruppen REST API",
            "Mestergruppen REST API",
            "1.0",
            "Terms of service",
            Contact("Mestergruppen Development", "www.mestergruppen.no", "developers@mestergruppen.no"),
            "", "", Collections.emptyList())
}