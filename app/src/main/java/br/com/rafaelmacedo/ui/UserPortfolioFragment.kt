package br.com.rafaelmacedo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.rafaelmacedo.core.CoreFragment
import br.com.rafaelmacedo.core.State
import br.com.rafaelmacedo.databinding.FragmentUserPortfolioBinding
import br.com.rafaelmacedo.presentation.UserPortfolioViewModel
import br.com.rafaelmacedo.ui.adapter.PortfolioAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class UserPortfolioFragment : CoreFragment() {

    private val viewModel: UserPortfolioViewModel by viewModel()
    private var _binding: FragmentUserPortfolioBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserPortfolioBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchData()
    }

    private fun setupObservers() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Loading -> state.invoke()
                is State.Error -> state.invoke()
                is State.Success -> state.invoke()
            }
        }
    }

    private fun State.Loading.invoke() {

    }

    private fun State.Success<List<String>>.invoke() {
        _binding?.rvInvestments?.run {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = PortfolioAdapter(this@invoke.data)
        }

    }

    private fun State.Error.invoke() {

    }
}