package sk.foldleft.crudjablka

import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.stereotype.Component

@Component
class RestRepositoryConfigurator : RepositoryRestConfigurer {
  override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
    config.exposeIdsFor(Apple::class.java)
  }
}

