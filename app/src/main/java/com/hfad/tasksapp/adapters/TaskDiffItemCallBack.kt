package com.hfad.tasksapp.adapters

import androidx.recyclerview.widget.DiffUtil
import com.hfad.tasksapp.data.Task

class TaskDiffItemCallBack: DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem.taskId == newItem.taskId


    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem ==newItem
}