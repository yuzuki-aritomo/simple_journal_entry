package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.SnackType
import com.okeicalm.simpleJournalEntry.usecase.snack.SnackCreateUseCase
import com.okeicalm.simpleJournalEntry.usecase.snack.SnackCreateUseCaseInput
import org.springframework.stereotype.Component

data class CreateSnackInput(val name: String, val price: Int)

@Component
class CreateSnackMutation(private val snackCreateUseCase: SnackCreateUseCase) : Mutation {
    fun createSnack(input: CreateSnackInput): SnackType {
        val output = snackCreateUseCase.call(
            SnackCreateUseCaseInput(
                name = input.name,
                price = input.price
            )
        )
        return SnackType(output.snack)
    }
}
