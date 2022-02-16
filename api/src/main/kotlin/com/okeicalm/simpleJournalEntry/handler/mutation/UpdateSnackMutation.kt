package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.SnackType
import com.okeicalm.simpleJournalEntry.usecase.snack.SnackUpdateUseCase
import com.okeicalm.simpleJournalEntry.usecase.snack.SnackUpdateUseCaseInput
import com.okeicalm.simpleJournalEntry.usecase.snack.SnackUpdateUseCaseOutput
import org.springframework.stereotype.Component

data class UpdateSnackInput(val id: ID, val name: String, val price: Int)

@Component
class UpdateSnackMutation(private val snackUpdateUseCase: SnackUpdateUseCase) : Mutation {
    fun updateSnack(input: UpdateSnackInput): SnackType {
        val output: SnackUpdateUseCaseOutput = snackUpdateUseCase.call(
            SnackUpdateUseCaseInput(
                id = input.id.toString().toLong(),
                name = input.name,
                price = input.price
            )
        )
        return SnackType(output.snack)
    }
}
