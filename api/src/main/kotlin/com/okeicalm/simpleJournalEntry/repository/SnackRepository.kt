package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Snack

interface SnackRepository {
    fun findAll(): List<Snack>

    fun findById(id: Long): Snack?

    fun create(snack: Snack): Long

    fun update(id: Long, snack: Snack): Long
}
