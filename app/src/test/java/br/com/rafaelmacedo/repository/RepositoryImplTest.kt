package br.com.rafaelmacedo.repository

import br.com.rafaelmacedo.datasource.LocalDataSource
import br.com.rafaelmacedo.datasource.RemoteDataSource
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class RepositoryImplTest {

    lateinit var repositoryImpl: RepositoryImpl
    lateinit var remoteDataSource: RemoteDataSource
    lateinit var localDataSource: LocalDataSource

    @Before
    fun setup() {
        remoteDataSource = mockk()
        localDataSource = mockk()
        repositoryImpl = RepositoryImpl(remoteDataSource, localDataSource)
    }


    @Test
    fun requestRemoteUserPortfolioReturnPortfolio() {
        val mockData = listOf("Investment1", "Investment2")
        val expectedCount = mockData.size
        every { remoteDataSource.requestUserPortfolio() } returns mockData

        val result = repositoryImpl.requestRemoteUserPortfolio()

        assert(expectedCount == result.getInvestments().size)

    }

    @Test
    fun requestCacheUserPortfolioReturnPortfolio() {
        val mockData = listOf("Investment1", "Investment2")
        val expectedCount = mockData.size
        every { localDataSource.requestUserPortfolio() } returns mockData

        val result = repositoryImpl.requestCacheUserPortfolio()

        assert(expectedCount == result?.getInvestments()?.size)

    }
}