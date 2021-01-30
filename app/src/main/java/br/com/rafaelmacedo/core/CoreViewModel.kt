package br.com.rafaelmacedo.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class CoreViewModel<TState>(private val io: CoroutineDispatcher = Dispatchers.IO) :
    ViewModel() {
    protected val _state: MutableLiveData<State<TState>> = MutableLiveData()
    val state: LiveData<State<TState>> get() = _state

    protected fun launch(func: () -> Unit): Job {
        return GlobalScope.launch(io) {
            func.invoke()
        }
    }

}