package com.example.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kanban.R
import com.example.kanban.databinding.FragmentTodoBinding
import com.example.kanban.model.Status
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
        initReclyclerViewTask()
        getTask()
    }

    private fun initListeners() {

        binding.floatingActionButton2.setOnClickListener {

            findNavController().navigate((R.id.action_homeFragment_to_formTaskFragment))

        }
    }
    private fun initReclyclerViewTask(){
        taskAdapter= TaskAdapter(requireContext(),) {task, option-> optionSelected(task,option) }
        with(binding.recyclerViewTask){
            layoutManager= LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter=taskAdapter
        }

    }
    private fun optionSelected(task: Task,option: Int){
        when(option){
            TaskAdapter.SELECTED_REMOVER ->{
                Toast.makeText(requireContext(),"Removendo ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECTED_EDIT ->{
                Toast.makeText(requireContext(),"Editando ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECTED_DETAILS ->{
                Toast.makeText(requireContext(),"Destalhes ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECTED_NEXT ->{
            Toast.makeText(requireContext(),"Próximo ${task.description}", Toast.LENGTH_SHORT).show()
        }



        }
    }

    private fun getTask() {
        val taskList = listOf(
            Task("0", "Criar nova tela do app", Status.TODO),
            Task("1", "Validar informações na telas de login", Status.TODO),
            Task("2", "Tarefa 3", Status.TODO),
            Task("3", "Tarefa 4", Status.TODO),
            Task("4", "Tarefa 5", Status.TODO),
        )
        taskAdapter.submitList(taskList)
    }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
