package br.com.rafaelmacedo.usecase

import br.com.rafaelmacedo.repository.Repository
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class GetUserPortfolioTest {

    private lateinit var getUserPortfolio: GetUserPortfolio
    private lateinit var repository: Repository

    @Before
    fun setup() {
        repository = mockk()
        getUserPortfolio = GetUserPortfolio(repository)
    }

    @Test
    fun invokeShouldReturnUserPotfolio() {
        val expected = UserPortfolio(listOf())
        every { repository.requestRemoteUserPortfolio() } returns expected

        val result = getUserPortfolio.invoke()

        assert(expected == result)
    }
}