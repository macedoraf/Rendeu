package br.com.rafaelmacedo.presentation

import br.com.rafaelmacedo.core.CoreViewModel
import br.com.rafaelmacedo.core.State
import br.com.rafaelmacedo.usecase.GetUserPortfolio

class UserPortfolioViewModel(private val getUserPortfolio: GetUserPortfolio) :
    CoreViewModel<List<String>>() {

    fun fetchData() {
        launch {
            _state.postValue(State.Loading)
            _state.postValue(State.Success(getUserPortfolio.invoke().getInvestments()))
        }
    }
}