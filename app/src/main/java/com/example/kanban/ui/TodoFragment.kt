package com.example.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kanban.R
import com.example.kanban.databinding.FragmentTodoBinding
import com.example.kanban.model.Task
import com.example.kanban.ui.adapter.TaskAdapter

class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initReclyclerViewTask(getTask())
    }

    private fun initListeners() {

        binding.floatingActionButton2.setOnClickListener {

            findNavController().navigate((R.id.action_homeFragment_to_formTaskFragment))

        }
    }
    private fun initReclyclerViewTask(taskList: List<Task>){
        binding.recyclerViewTask.layoutManager= LinearLayoutManager(requireContext())
        binding.recyclerViewTask.setHasFixedSize(true)

        binding.recyclerViewTask.adapter = taskAdapter

    }
    private fun getTask()=listOf(
        Task("0", "Criar nova tela do app"),
        Task("1", "Validar informações na telas de login"),
        Task("2", "Tarefa 3"),
        Task("3", "Tarefa 4"),
        Task("4", "Tarefa 5"),
    )


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
