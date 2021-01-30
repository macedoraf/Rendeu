package br.com.rafaelmacedo.datasource

interface DataSource {
    fun requestUserPortfolio(): List<String>?
}