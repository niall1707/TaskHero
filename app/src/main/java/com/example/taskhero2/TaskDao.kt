package com.example.taskhero2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAll(): List<Task>

    @Insert
    fun insertAll(vararg tasks: Task)
}
