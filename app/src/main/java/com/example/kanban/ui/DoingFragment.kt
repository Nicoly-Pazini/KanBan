package com.example.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kanban.databinding.FragmentDoingBinding
import com.example.kanban.model.Status
import com.example.kanban.model.Task
import com.example.kanban.ui.adapter.TaskAdapter


class DoingFragment : Fragment() {
    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDoingBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        initReclyclerViewTask(getTask())
    }
    private fun initReclyclerViewTask(taskList: List<Task>){
        taskAdapter= TaskAdapter(requireContext(),taskList) {task, option-> optionSelected(task,option) }
        binding.recyclerViewTask.layoutManager= LinearLayoutManager(requireContext())
        binding.recyclerViewTask.setHasFixedSize(true)
        binding.recyclerViewTask.adapter = taskAdapter

    }
    private fun optionSelected(task: Task,option: Int){

    }

    private fun getTask()=listOf(
        Task("1", "Validar informações na telas de login", Status.TODO),
        Task("0", "Criar nova tela do app", Status.TODO),
        Task("2", "Tarefa 3", Status.TODO),
        Task("3", "Tarefa 4", Status.TODO),
        Task("4", "Tarefa 5", Status.TODO),
    )
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}