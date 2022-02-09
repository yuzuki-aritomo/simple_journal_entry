package com.okeicalm.simpleJournalEntry.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.tables.Snacks
import org.jooq.DSLContext

@Repository
class SnackRepositoryImpl @Autowired constructor(private val dslContext: DSLContext) : SnackRepository{
    override fun findAll(): List<Snack> {
        val result = dslContext.select()
            .from(Snacks.SNACKS)
            .fetch()
            .into(com.okeicalm.simpleJournalEntry.tables.pojos.Snacks::class.java)

        return result.map { Snack(it) }
    }
}