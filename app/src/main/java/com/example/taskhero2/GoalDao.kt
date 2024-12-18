package com.example.taskhero2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GoalDao {
    @Insert
    fun insert(goal: Goal)

    @Query("SELECT * FROM goal")
    fun getAllGoals(): List<Goal>

    @Delete
    fun delete(goal: Goal)

    @Update
    fun update(goal: Goal)


}
