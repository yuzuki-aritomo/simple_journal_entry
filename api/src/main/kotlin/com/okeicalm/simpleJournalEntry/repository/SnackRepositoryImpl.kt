package com.okeicalm.simpleJournalEntry.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.tables.Snacks
import com.okeicalm.simpleJournalEntry.tables.pojos.Snacks as SnacksPojos
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

    override fun findById(id: Long): Snack? {
        val snackPOJO : SnacksPojos? = dslContext
            .fetchOne(Snacks.SNACKS, Snacks.SNACKS.ID.eq(id))
            ?.into(SnacksPojos::class.java)
        return snackPOJO?.let { Snack(it) }
    }
}