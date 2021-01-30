package br.com.rafaelmacedo.datasource

import android.content.SharedPreferences

class LocalDataSource(private val sharedPreferences: SharedPreferences) : DataSource {
    private val keyPortfolio = "PORTFOLIO"

    override fun requestUserPortfolio(): List<String>? {
        val set = sharedPreferences.getStringSet(keyPortfolio, setOf())
        return set?.toList()
    }

    fun saveCacheUserPortfolio(investments: List<String>) {
        sharedPreferences.edit().run {
            putStringSet(keyPortfolio, investments.toSet())
            apply()
        }
    }

}