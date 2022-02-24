
package com.okeicalm.simpleJournalEntry.usecase.snack

import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.repository.SnackRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class SnackCreateUseCaseInput(val name: String, val price: Int)
data class SnackCreateUseCaseOutput(val snack: Snack)

interface SnackCreateUseCase {
    fun call(input: SnackCreateUseCaseInput): SnackCreateUseCaseOutput
}

@Service
class SnackCreateUseCaseImpl(private val snackRepository: SnackRepository) : SnackCreateUseCase {
    @Transactional
    override fun call(input: SnackCreateUseCaseInput): SnackCreateUseCaseOutput {
        val snack = Snack(
            name = input.name,
            price = input.price
        )
        val newSnackId = snackRepository.create(snack)
        val newSnack = snackRepository.findById(newSnackId) ?: throw Exception("SnackCreateUseCase: Something wrong...")
        return SnackCreateUseCaseOutput(newSnack)
    }
}
