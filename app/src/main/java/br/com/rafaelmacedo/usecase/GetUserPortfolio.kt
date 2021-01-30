package br.com.rafaelmacedo.usecase

import android.util.Log
import br.com.rafaelmacedo.repository.Repository

class GetUserPortfolio(private val repository: Repository) {

    fun invoke(): UserPortfolio {
        val cache = repository.requestCacheUserPortfolio()
        return if (cache != null && cache.getInvestments().isNotEmpty()) {
            Log.i("UserPortfolio","Data from cache")
            cache
        } else {
            Log.i("UserPortfolio","Data from remote")
            val remote = repository.requestRemoteUserPortfolio()
            repository.saveCacheUserPortfolio(remote.getInvestments())
            remote
        }
    }
}