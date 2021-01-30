package br.com.rafaelmacedo.datasource

class RemoteDataSource : DataSource {
    override fun requestUserPortfolio(): List<String> = listOf("PETR4", "SAMB11", "ITUB4")

}