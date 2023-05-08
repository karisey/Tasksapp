package com.hfad.tasksapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hfad.tasksapp.adapters.TaskItemAdapter
import com.hfad.tasksapp.data.TaskDatabase
import com.hfad.tasksapp.databinding.FragmentTasksBinding


class TasksFragment : Fragment() {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTasksBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = TaskDatabase.getInstance(application).taskDao

        val viewModelFactory = TasksViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(TasksViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = TaskItemAdapter()
        binding.tasksList.adapter = adapter

        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            it?.let {

                adapter.data = it
                // When the list of tasks changes,assign ot to the adapters data property
            }


        })


        binding.saveButton.setOnClickListener {
            if (binding.taskName.text.isEmpty()) {
                Toast.makeText(this.activity, "Please enter a valid task name", Toast.LENGTH_LONG)
                    .show()

            } else {
                viewModel.addtask()
                binding.taskName.setText("")


            }


        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}