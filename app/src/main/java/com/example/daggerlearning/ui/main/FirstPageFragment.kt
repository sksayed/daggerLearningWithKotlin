package com.example.daggerlearning.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.daggerlearning.R
import com.example.daggerlearning.databinding.FragmentFirstPageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class FirstPageFragment : BaseFragment() {

    companion object {
        fun newInstance() = FirstPageFragment()
    }

    private lateinit var binding: FragmentFirstPageBinding

    private  val viewModel: FirstPageViewModel by viewModels<FirstPageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToSecondPage.setOnClickListener {
            launchInViewLifeCycle {
                viewModel.buttonClick().collect{
                    println("Printing inside fragment Collect ")
                    binding.tv1.text = it.title
                    delay(2000L)
                    findNavController().navigate(R.id.action_firstPageFragment_to_secondFragment)
                }

            }
        }

        viewModel.postLiveData.observe(viewLifecycleOwner , Observer {
            println("printing from inside observer")
            binding.tv1.text = it.userId.toString()
        })
    }

    override fun onDestroyView() {
        println("on destroy view is called on first fragment ")
        super.onDestroyView()
    }


}