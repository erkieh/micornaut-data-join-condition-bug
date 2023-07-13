package com.example

import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.runtime.criteria.get
import io.micronaut.data.runtime.criteria.joinMany
import io.micronaut.data.runtime.criteria.joinOne
import io.micronaut.http.annotation.*
import jakarta.transaction.Transactional
import java.util.*

@Controller("/person/")
open class PersonController(
        private val personRepository: PersonRepository
) {

    @Get("filter")
    @Transactional
    open fun filter(): Page<Person> {
        return personRepository.findAll({ root, criteriaBuilder ->
            val friends = root.joinMany(Person::friends)
            criteriaBuilder.and(friends[Person::id].`in`(listOf(1L)))
        }, Pageable.from(1, 2))
    }
}