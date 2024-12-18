package com.example.taskhero2


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    var description: String,
    val completeBy: String
)
