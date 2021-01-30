package br.com.rafaelmacedo.repository

import br.com.rafaelmacedo.datasource.LocalDataSource
import br.com.rafaelmacedo.datasource.RemoteDataSource
import br.com.rafaelmacedo.usecase.UserPortfolio

class RepositoryImpl(private val remote: RemoteDataSource, private val local: LocalDataSource) :
    Repository {

    override fun requestRemoteUserPortfolio(): UserPortfolio =
        UserPortfolio(remote.requestUserPortfolio())

    override fun requestCacheUserPortfolio(): UserPortfolio? =
        local.requestUserPortfolio()?.let {
            UserPortfolio(it)
        }

    override fun saveCacheUserPortfolio(investments: List<String>) {
        local.saveCacheUserPortfolio(investments)
    }

}