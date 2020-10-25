package sk.foldleft.crudjablka

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface AppleRepo : JpaRepository<Apple, Long>

