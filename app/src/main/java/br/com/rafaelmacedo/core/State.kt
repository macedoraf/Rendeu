package br.com.rafaelmacedo.core

sealed class State<out T> {
    object Loading : State<Nothing>()
    data class Success<T>(val data: T) : State<T>()
    data class Error(
        val throwable: Throwable
    ) : State<Nothing>()
}