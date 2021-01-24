package br.com.rafaelmacedo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val appModule = module {
    single { GetData() }
    viewModel { FirstScreenViewModel(getData = get()) }
}