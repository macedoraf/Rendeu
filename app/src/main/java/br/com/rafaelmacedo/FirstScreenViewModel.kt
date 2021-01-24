package br.com.rafaelmacedo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class FirstScreenViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val getData: GetData
) :
    ViewModel() {
    private var data = State.Loading
    private val _state = MutableStateFlow<State<FirstScreenData>>(data)
    val state: StateFlow<State<FirstScreenData>> get() = _state

    fun loadData() {
        viewModelScope.launch {
            _state.value = State.Loading
            val result = withContext(dispatcher) {
                return@withContext getData.execute()
            }

            _state.value = State.Success(result)
        }
    }
}