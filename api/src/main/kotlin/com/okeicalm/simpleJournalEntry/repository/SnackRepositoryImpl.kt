package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.tables.Snacks
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import com.okeicalm.simpleJournalEntry.tables.pojos.Snacks as SnacksPojos

@Repository
class SnackRepositoryImpl @Autowired constructor(private val dslContext: DSLContext) : SnackRepository {
    override fun findAll(): List<Snack> {
        val result = dslContext.select()
            .from(Snacks.SNACKS)
            .fetch()
            .into(com.okeicalm.simpleJournalEntry.tables.pojos.Snacks::class.java)

        return result.map { Snack(it) }
    }

    override fun findById(id: Long): Snack? {
        val snackPOJO: SnacksPojos? = dslContext
            .fetchOne(Snacks.SNACKS, Snacks.SNACKS.ID.eq(id))
            ?.into(SnacksPojos::class.java)
        return snackPOJO?.let { Snack(it) }
    }

    override fun create(snack: Snack): Long {
        dslContext
            .newRecord(Snacks.SNACKS)
            .setName(snack.name)
            .setPrice(snack.price)
            .store()
        return dslContext.lastID().toLong()
    }

    override fun update(id: Long, snack: Snack): Long {
        dslContext
            .update(Snacks.SNACKS)
            .set(Snacks.SNACKS.NAME, snack.name)
            .set(Snacks.SNACKS.PRICE, snack.price)
            .where(Snacks.SNACKS.ID.eq(id))
            .execute()
        return id
    }
}
