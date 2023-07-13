package com.example

import io.micronaut.data.annotation.Repository
import io.micronaut.data.annotation.RepositoryConfiguration
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.query.builder.jpa.JpaQueryBuilder
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor

@RepositoryConfiguration(queryBuilder = JpaQueryBuilder::class)
@Repository
interface PersonRepository : JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
}