package com.example.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kanban.databinding.FragmentDoingBinding
import com.example.kanban.model.Task


class DoingFragment : Fragment() {
    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDoingBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun getTask()=listOf(
        Task("1", "Validar informações na telas de login"),
        Task("0", "Criar nova tela do app"),
        Task("2", "Tarefa 3"),
        Task("3", "Tarefa 4"),
        Task("4", "Tarefa 5"),
    )
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}