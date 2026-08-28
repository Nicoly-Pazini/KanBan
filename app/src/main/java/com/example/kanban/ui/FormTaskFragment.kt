package com.example.kanban.ui

import android.R.attr.text
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kanban.R
import com.example.kanban.databinding.FragmentFormTaskBinding
import com.example.kanban.databinding.FragmentRecoverAccountBinding
import com.example.kanban.util.initToolbar
import com.example.kanban.util.showBottomSheet


class FormTaskFragment : Fragment() {
    private var _binding: FragmentFormTaskBinding? =null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding= FragmentFormTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }
    private fun initListener(){
        binding.buttonSave.setOnClickListener{
            validateData()
        }
    }

    private fun validateData(){
        val description = binding.editTextDescricao.text.toString().trim()
        if (description.isNotBlank()){

        }else{
            showBottomSheet(message = getString(R.string.description_empty_form_tak_fragment))
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}