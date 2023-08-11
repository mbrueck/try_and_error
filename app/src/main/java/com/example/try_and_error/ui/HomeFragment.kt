package com.example.try_and_error.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.try_and_error.R
import com.example.try_and_error.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
        private val viewModel: HomeviewModel by activityViewModels()
        private lateinit var binding : FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
        binding.btnPlus.setOnClickListener {
            viewModel.increaseScore()
        }
        binding.btnMinus.setOnClickListener {
            viewModel.decreaseScore()
        }

    }

    private fun addObservers(){
        viewModel.score.observe(viewLifecycleOwner, Observer {
            binding.tvCounternumber.text = it.toString()
        })
    }
}