package com.okeicalm.simpleJournalEntry.usecase.snack

import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.repository.SnackRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class SnackCreateUseCaseTests: DescribeSpec({
    lateinit var usecase: SnackCreateUseCase
    val repository = mockk<SnackRepository>()

    beforeEach {
        usecase= SnackCreateUseCaseImpl(repository)
    }

    describe("call"){
        context("when success"){
            val input = SnackCreateUseCaseInput(name = "chocolate", price = 120)
            val snack = Snack(name = "chocolate", price = 120)

            every { repository.create(snack) } returns 1
            every { repository.findById(1) } returns snack.copy(id = 1)

            it("return new snack"){
                val output = usecase.call(input)
                output.snack.id.shouldBe(1)
                output.snack.name.shouldBe("chocolate")
                output.snack.price.shouldBe(120)
            }
        }

        context("when failed"){
            val input = SnackCreateUseCaseInput(name = "chocolate", price = 120)
            val snack = Snack(name = "chocolate", price = 120)

            every { repository.create(snack) } returns 1
            every { repository.findById(1) } returns null

            it("throws Exception"){
                shouldThrow<Exception> {
                    usecase.call(input)
                }
            }
        }
    }

})
