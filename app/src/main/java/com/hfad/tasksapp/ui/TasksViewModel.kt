package com.hfad.tasksapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.tasksapp.data.Task
import com.hfad.tasksapp.data.TaskDao
import kotlinx.coroutines.launch

class TasksViewModel(val dao: TaskDao): ViewModel() {

    var newTaskName = ""
    val tasks = dao.getAll()  //Returns a live data list of Task objects i.e  LiveData<List<Task>>
    private val _navigateToTask = MutableLiveData<Long?>()

    val navigateToTask:LiveData<Long?>
            get()= _navigateToTask


    fun onTaskClicked(itemId:Long) {
        _navigateToTask.value = itemId
    }
    fun onTaskNavigated() {

        _navigateToTask.value = null
    }



    fun addTask(){

        val task = Task()
        viewModelScope.launch{
            task.taskName = newTaskName
            dao.insert(task)


        }




        /*
        *Instead of formatting the LiveData<List><Task> as a string , I changed the code to use a recyclerview instead
        *
         */

   /* val tasksString = Transformations.map(tasks){
        tasks -> formatTasks(tasks)

    }



    private fun formatTasks(tasks: List<Task>): String {
        return tasks.fold(""){
            str,item  -> str + "/n" + formatTask(item)

        }

    }

    private fun formatTask(item: Task):String {
        var str = "ID: ${item.taskId} + /n "
        str += "Name: ${item.taskName} + /n"
        str += "Complete: ${item.taskDone} + /n"
        return str

    }

    */







    }



}