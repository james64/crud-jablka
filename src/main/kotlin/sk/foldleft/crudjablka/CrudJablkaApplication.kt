package sk.foldleft.crudjablka

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.function.Consumer

@SpringBootApplication
class CrudJablkaApplication {

  @Bean
  fun init(repo: AppleRepo): ApplicationRunner {
    return ApplicationRunner { _: ApplicationArguments? ->
      arrayOf("red", "green", "yellow").forEach {
        repo.save(Apple(it, 10))
      }
      repo.findAll().forEach(Consumer { x: Apple? -> println(x) })
    }
  }

   @Bean
   fun simpleCorsFilter(): FilterRegistrationBean<*> {
       val source = UrlBasedCorsConfigurationSource()
       val config = CorsConfiguration()
       config.allowCredentials = true
       // *** URL below needs to match the Vue client URL and port ***
       config.allowedOrigins = listOf("http://localhost:8080")
       config.allowedMethods = listOf("*")
       config.allowedHeaders = listOf("*")
       source.registerCorsConfiguration("/**", config)
       val bean: FilterRegistrationBean<*> = FilterRegistrationBean(CorsFilter(source))
       bean.order = Ordered.HIGHEST_PRECEDENCE
       return bean
   }
}

fun main(args: Array<String>) {
    runApplication<CrudJablkaApplication>(*args)
}
