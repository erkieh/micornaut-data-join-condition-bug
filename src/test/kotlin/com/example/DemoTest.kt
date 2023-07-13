package com.example

import io.micronaut.data.model.Pageable
import io.micronaut.data.runtime.criteria.get
import io.micronaut.data.runtime.criteria.joinMany
import io.micronaut.data.runtime.criteria.joinOne
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test

@MicronautTest
class DemoTest {
    @Inject
    lateinit var personRepository: PersonRepository

    @Test
    fun testItWorks() {
        personRepository.findAll({ root, criteriaBuilder ->
            val childs = root.joinMany(Person::childs)
            val friends = root.joinMany(Person::friends)
            val parent = root.joinOne(Person::parent)

            criteriaBuilder.and(friends[Person::id].`in`(listOf(1L)),
                    parent[Person::id].`in`(listOf(1L)),
                    childs[Person::id].`in`(listOf(1L)))
        }, Pageable.from(1, 2))
    }
}
