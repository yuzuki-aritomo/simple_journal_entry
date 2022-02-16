package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.SnackType
import com.okeicalm.simpleJournalEntry.usecase.snack.SnackDeleteUseCase
import com.okeicalm.simpleJournalEntry.usecase.snack.SnackDeleteUseCaseInput
import org.springframework.stereotype.Component

data class DeleteSnackInput(val id: ID)

@Component
class DeleteSnackMutation(private val snackDeleteUseCase: SnackDeleteUseCase) : Mutation {
    fun deleteSnack(input: DeleteSnackInput): SnackType {
        val output = snackDeleteUseCase.call(SnackDeleteUseCaseInput(id = input.id.toString().toLong()))
        return SnackType(output.snack)
    }
}
