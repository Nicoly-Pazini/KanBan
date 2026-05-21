package com.example.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kanban.R
import com.example.kanban.databinding.FragmentDoneBinding
import com.example.kanban.databinding.FragmentHomeBinding
import com.example.kanban.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
    }
    private fun initTabs(){
        val pageAdapter = ViewPagerAdapter(requireActivity())
        binding.viewPaper.adapter=pageAdapter
        pageAdapter.addFragment(TodoFragment(), R.string.status_task_todo)
        pageAdapter.addFragment(TodoFragment(), R.string.status_task_doing)
        pageAdapter.addFragment(TodoFragment(), R.string.status_task_done)

        binding.viewPaper.offscreenPageLimit=pageAdapter.itemCount
        TabLayoutMediator(binding.tabs,binding.viewPaper){ tab, position ->
            tab.text=getString(pageAdapter.getTitle(position))
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}

