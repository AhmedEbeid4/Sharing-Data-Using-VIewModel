package com.example.sharingdatausingviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.sharingdatausingviewmodel.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {


    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: CounterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel= ViewModelProvider(requireActivity())[CounterViewModel::class.java]
        binding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_second,container,false)
        viewModel.getCounter().observe(viewLifecycleOwner, Observer {
            binding.number.text = it.toString()
        })
        binding.decBtn.setOnClickListener {
            viewModel.dec()
        }
        binding.backBtn.setOnClickListener {
            val action=SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}