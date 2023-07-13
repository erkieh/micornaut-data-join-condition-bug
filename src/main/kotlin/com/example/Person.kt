package com.example

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*

@Entity
@Table
@Serdeable
open class Person(
        @Column(nullable = false)
        open var name: String,
        @Id
        @GeneratedValue
        @Column
        open var id: Long? = null,
        @ManyToMany
        open var friends: MutableSet<Person> = LinkedHashSet(),
        @OneToMany
        open var childs: MutableSet<Person> = LinkedHashSet(),
        @ManyToOne
        open var parent: Person,
)