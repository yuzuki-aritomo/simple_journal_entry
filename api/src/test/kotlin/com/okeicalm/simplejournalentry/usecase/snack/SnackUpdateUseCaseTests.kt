package com.okeicalm.simpleJournalEntry.usecase.snack

import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.repository.SnackRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class SnackUpdateUseCaseTests : DescribeSpec({
    lateinit var usecase: SnackUpdateUseCase
    val repository = mockk<SnackRepository>()

    beforeEach {
        usecase = SnackUpdateUseCaseImpl(repository)
    }

    describe("call"){
        context("when success"){
            val input = SnackUpdateUseCaseInput(id = 1, name = "cookie", price = 80)
            val snack = Snack(name = "cookie", price = 80)

            every { repository.update(id = 1, snack = snack) } returns 1
            every { repository.findById(1) } returns snack.copy(id = 1)

            it("return updated snack"){
                val output = usecase.call(input)
                output.snack.id.shouldBe(1)
                output.snack.name.shouldBe("cookie")
                output.snack.price.shouldBe(80)
            }
        }

        context("when failed"){
            val input = SnackUpdateUseCaseInput(id = 1, name = "cookie", price = 80)
            val nack = Snack(name = "cookie", price = 80)

            every { repository.update(id = 1, snack = nack) } returns 1
            every { repository.findById(1) } returns null

            it("throws Exception"){
                shouldThrow<Exception> {
                    usecase.call(input)
                }
            }
        }
    }
})