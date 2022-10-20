package com.example.sharingdatausingviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.sharingdatausingviewmodel.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding:FragmentFirstBinding
    private val viewModel:CounterViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_first,container,false)
        viewModel.getCounter().observe(viewLifecycleOwner, Observer {
            binding.number.text = it.toString()
        })
        binding.incBtn.setOnClickListener {
            viewModel.inc()
        }
        binding.nextBtn.setOnClickListener {
            val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}