package com.example.myfirstapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapp.databinding.ExampleFragmentBinding
import com.example.myfirstapp.di.getAppComponent
import com.example.myfirstapp.ui.ExFragmentViewModel
import com.example.myfirstapp.utils.viewModels
import com.github.terrakok.cicerone.Router
import retrofit2.Retrofit
import javax.inject.Inject


class ExFragment : Fragment(R.layout.example_fragment) {

    companion object {
        const val ARG_NUMBER = "number"
        fun newInstance(number: Int) = ExFragment().apply {
            arguments = bundleOf(
                ARG_NUMBER to number
            )
        }
    }

    private val number get() = arguments?.getInt(ARG_NUMBER, -1) ?: -1

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModelFactory: ExFragmentViewModel.Factory

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var service: Service

    private val viewModel by viewModels { viewModelFactory.get(number) }

    private lateinit var binding: ExampleFragmentBinding

    override fun onAttach(context: Context) {
        context.getAppComponent().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chainText = (activity as MainActivity).getChain()

        binding = ExampleFragmentBinding.bind(view)
        with(binding) {
            textView3.text = chainText
            button2.setOnClickListener {
                viewModel.nextScreen()
            }
            button3.setOnClickListener {
                viewModel.exit()
            }
            button4.setOnClickListener {
                viewModel.someButton4(chainText)
            }
            button5.setOnClickListener {
                viewModel.someButton5()
            }
            with(recyclerview) {
                layoutManager = LinearLayoutManager(context)
                adapter = viewModel.getAdapter()
            }
            button6.setOnClickListener {
                viewModel.someButton6(requireContext())
            }
        }
    }
}

