package com.example.pdptask_4_8_2kotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pdptask_4_8_2kotlin.data.DataClass
import com.example.pdptask_4_8_2kotlin.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var name: TextView? = null
    private var text: TextView? = null

     var  _binding:FragmentSecondBinding?=null
     val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun updateSecondFragment(dataClass: DataClass){
        binding.name.setText(dataClass.name)
        binding.text.setText(dataClass.text)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}