package com.hfad.tasksapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(task: Task)

    @Insert
    suspend fun insertAll(tasks: List<Task>)

    @Update
    suspend fun update(task: Task) // This will update the record with a matching task Id

    @Delete
    suspend fun delete(task: Task) // Delete a record with a matchind task id

    @Delete
    suspend fun deleteAll(tasks:List<Task>)

    @Query("SELECT * FROM task_table WHERE taskId = :taskId")
    fun get(taskId: Long) : LiveData<Task>

    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAll() : LiveData<List<Task>>



}