package com.example.taskhero2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewGoalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_goal_activity)

        val btnSubmitGoal = findViewById<Button>(R.id.buttonSubmitGoal)
        btnSubmitGoal.setOnClickListener {
            // Handle the goal submission
        }
    }
}
