package com.okeicalm.simpleJournalEntry.usecase.snack

import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.repository.SnackRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class SnackUpdateUseCaseInput(val id: Long, val name: String, val price: Int)
data class SnackUpdateUseCaseOutput(val snack: Snack)

interface SnackUpdateUseCase {
    fun call(input: SnackUpdateUseCaseInput): SnackUpdateUseCaseOutput
}

@Service
class SnackUpdateUseCaseImpl(private val snackRepository: SnackRepository) : SnackUpdateUseCase {
    @Transactional
    override fun call(input: SnackUpdateUseCaseInput): SnackUpdateUseCaseOutput {
        val snack = Snack(
            name = input.name,
            price = input.price
        )
        snackRepository.update(input.id, snack)
        val updatedSnack = snackRepository.findById(input.id) ?: throw Exception("AccountingUpdateUseCase: Something wrong...")
        return SnackUpdateUseCaseOutput(updatedSnack)
    }
}
