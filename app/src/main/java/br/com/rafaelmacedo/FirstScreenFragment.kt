package br.com.rafaelmacedo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.rafaelmacedo.databinding.FragmentFirstScreenBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.onEach
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class FirstScreenFragment : Fragment() {

    private var _binding: FragmentFirstScreenBinding? = null
    private val viewModel: FirstScreenViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstScreenBinding.inflate(layoutInflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.onEach {
            when (it) {
                is State.Success -> {

                }

                is State.Loading -> {

                }

                is State.Error -> {

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}