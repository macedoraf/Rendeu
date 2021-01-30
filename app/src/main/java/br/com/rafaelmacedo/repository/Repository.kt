package br.com.rafaelmacedo.repository

import br.com.rafaelmacedo.usecase.UserPortfolio

interface Repository {
    fun requestRemoteUserPortfolio(): UserPortfolio
    fun requestCacheUserPortfolio(): UserPortfolio?
    fun saveCacheUserPortfolio(investments: List<String>)
}