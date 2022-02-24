package com.okeicalm.simpleJournalEntry.usecase.snack

import com.okeicalm.simpleJournalEntry.entity.Snack
import com.okeicalm.simpleJournalEntry.repository.SnackRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class SnackDeleteUseCaseTests : DescribeSpec({
    lateinit var usecase: SnackDeleteUseCase
    var repository = mockk<SnackRepository>()

    beforeEach {
        usecase= SnackDeleteUseCaseImpl(repository)
    }

    describe("call"){
        context("when success"){
            val input = SnackDeleteUseCaseInput(id = 1)
            val snack = Snack(name = "chocolate", price = 120)

            every { repository.delete(1) } returns 1
            every { repository.findById(1) } returns snack.copy(id = 1)

            it("return deleted snack"){
                val output = usecase.call(input)
                output.snack.id.shouldBe(1)
                output.snack.name.shouldBe("chocolate")
                output.snack.price.shouldBe(120)
            }
        }

        context("when failed"){
            val input = SnackDeleteUseCaseInput(id = 1)

            every { repository.delete(1) } returns 1
            every { repository.findById(1) } returns null

            it("throws Exception"){
                shouldThrow<Exception> {
                    usecase.call(input)
                }
            }
        }
    }
})