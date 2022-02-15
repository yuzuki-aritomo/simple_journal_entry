package com.okeicalm.simpleJournalEntry.entity

import com.okeicalm.simpleJournalEntry.tables.pojos.Snacks

data class Snack(
    val id: Long = 0,
    val name: String,
    val price: Int,
) {
    constructor(snack: Snacks) : this(
        snack.id,
        snack.name,
        snack.price
    )
}
