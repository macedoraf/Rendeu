package br.com.rafaelmacedo.di

import android.content.Context
import android.content.SharedPreferences
import br.com.rafaelmacedo.R
import br.com.rafaelmacedo.datasource.LocalDataSource
import br.com.rafaelmacedo.datasource.RemoteDataSource
import br.com.rafaelmacedo.presentation.UserPortfolioViewModel
import br.com.rafaelmacedo.repository.Repository
import br.com.rafaelmacedo.repository.RepositoryImpl
import br.com.rafaelmacedo.usecase.GetUserPortfolio
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userPortfolioModule = module {
    viewModel { UserPortfolioViewModel(get()) }
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            androidContext().getString(
                R.string.app_shared_preferences_context
            ), Context.MODE_PRIVATE
        )
    }
    single { LocalDataSource(get()) }
    single { RemoteDataSource() }
    single<Repository> { RepositoryImpl(get(), get()) }
    single { GetUserPortfolio(get()) }
}