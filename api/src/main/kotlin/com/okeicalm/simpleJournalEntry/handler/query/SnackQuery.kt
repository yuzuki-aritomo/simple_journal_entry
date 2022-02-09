package com.okeicalm.simpleJournalEntry.handler.query

import com.okeicalm.simpleJournalEntry.repository.SnackRepository
import org.springframework.stereotype.Component
import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.SnackType

@Component
class SnackQuery (private val repository: SnackRepository): Query{
    fun allSnacks(): List<SnackType> {
        return repository.findAll().map{ SnackType(it) }
    }
}