package com.okeicalm.simpleJournalEntry.usecase.snack

import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.repository.SnackRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class SnackDeleteUseCaseInput(val id: Long)
data class SnackDeleteUseCaseOutput(val snack: Snack)

interface SnackDeleteUseCase {
    fun call(input: SnackDeleteUseCaseInput): SnackDeleteUseCaseOutput
}

@Service
class SnackDeleteUseCaseImpl(private val snackRepository: SnackRepository) : SnackDeleteUseCase {
    @Transactional
    override fun call(input: SnackDeleteUseCaseInput): SnackDeleteUseCaseOutput {
        val deleteSnack = snackRepository.findById(input.id) ?: throw Exception("SnackDeleteUseCase: Something wrong...")
        snackRepository.delete(input.id)
        return SnackDeleteUseCaseOutput(deleteSnack)
    }
}
