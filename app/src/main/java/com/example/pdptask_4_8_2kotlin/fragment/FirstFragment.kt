package com.example.pdptask_4_8_2kotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pdptask_4_8_2kotlin.data.DataClass
import com.example.pdptask_4_8_2kotlin.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

     var _binding:FragmentFirstBinding?=null
     val binding get() = _binding!!
     var listener:FirstListener?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.btnFirst.setOnClickListener(View.OnClickListener {

            val name = binding.editName.text.toString()
            val text = binding.editText.text.toString()

            val dataClass= DataClass(name, text)
            listener?.onFirstSend(dataClass)

        })

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstListener){
            listener =  context
        } else {
            throw RuntimeException(context.toString() + "must implement FirstListener")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

      interface FirstListener {
          fun onFirstSend(dataClass: DataClass)
    }
}