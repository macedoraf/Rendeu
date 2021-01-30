package br.com.rafaelmacedo.usecase

class UserPortfolio(private val investments: List<String>) {
    fun getInvestments(): List<String> = investments
}