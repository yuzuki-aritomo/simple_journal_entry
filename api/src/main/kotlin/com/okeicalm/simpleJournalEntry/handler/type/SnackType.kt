package com.okeicalm.simpleJournalEntry.handler.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.okeicalm.simpleJournalEntry.entity.Snack

const val snackTypeGraphQLName = "Snack"

@GraphQLName(snackTypeGraphQLName)
data class SnackType(
    val id: ID,
    val name: String,
    val price: Int
) {
    constructor(snack: Snack) : this(
        ID(snack.id.toString()),
        snack.name,
        snack.price
    )
}
