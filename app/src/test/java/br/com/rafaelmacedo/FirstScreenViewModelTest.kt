package br.com.rafaelmacedo

import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class FirstScreenViewModelTest : TestCase() {
    @get:Rule
    val rule = MainCoroutineRule()
    private val getData: GetData = GetData()

    private val viewModel: FirstScreenViewModel =
        FirstScreenViewModel(dispatcher = rule.testDispatcher, getData = getData)


    @Test
    fun testInitialState() {
        viewModel.loadData()
        val currentState = viewModel.state.value
        assertTrue(currentState is State.Loading)
    }

    @Test
    fun loadDataTest() {
        val expected = State.Success(FirstScreenData())
        viewModel.loadData()

    }
}