package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Snack

interface SnackRepository {
    fun findAll(): List<Snack>
}