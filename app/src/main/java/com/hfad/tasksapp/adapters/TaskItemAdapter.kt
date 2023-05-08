package com.hfad.tasksapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.hfad.tasksapp.R

import com.hfad.tasksapp.data.Task


class TaskItemAdapter : RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {
    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()


        }


    class TaskItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {

        private val taskName = rootView.findViewById<TextView>(R.id.tvtask_name)
        private val taskDone = rootView.findViewById<CheckBox>(R.id.cbtask_done)
        fun bind(item: Task) {
            taskName.text = item.taskName
            taskDone.isChecked = item.taskDone

        }


        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                return TaskItemViewHolder(view)
            }

        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TaskItemAdapter.TaskItemViewHolder =
        TaskItemAdapter.TaskItemViewHolder.inflateFrom(parent)



    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)


    }

    override fun getItemCount() = data.size

}