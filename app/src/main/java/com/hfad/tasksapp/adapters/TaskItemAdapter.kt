package com.hfad.tasksapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hfad.tasksapp.data.Task
import com.hfad.tasksapp.databinding.TaskItemBinding


class TaskItemAdapter(val clickListener: (taskId:Long) -> Unit) :
    ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallBack()) {


    /*
    *Remove the data property since the list adapter implements its own backing list

     var data = listOf<Task>()
         set(value) {
             field = value
             notifyDataSetChanged()


         }

     */


    class TaskItemViewHolder(val binding: TaskItemBinding)
        : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Task,clickListener: (taskId: Long) -> Unit) {
            binding.task = item
            binding.root.setOnClickListener{ clickListener(item.taskId) }

        }


        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                // val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskItemViewHolder(binding)
            }

        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TaskItemAdapter.TaskItemViewHolder =
        TaskItemAdapter.TaskItemViewHolder.inflateFrom(parent)


    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,clickListener)



    }


}