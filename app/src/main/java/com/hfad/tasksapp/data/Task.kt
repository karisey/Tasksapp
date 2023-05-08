package com.hfad.tasksapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(

    @PrimaryKey(autoGenerate = true)
    val taskId: Long = 0L,

    @ColumnInfo("task_name")
    var taskName: String = "",

    @ColumnInfo(name = "task_done")
    val taskDone: Boolean = false


)





