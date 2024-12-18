package com.example.taskhero2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProgressActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        // Placeholder data
        val streak = 4
        val leaderboardPosition = "5th"
        val tasksCompleted = 27
        val weeklyProgress = "47%"

        // Set a click listener for the home button so it returns to the dashboard
        val btnAddGoal = findViewById<Button>(R.id.btnhome)
        btnAddGoal.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        //sets the linear layout to act as if it were a buttoin and bring to add goal page
        val layoutAddTask = findViewById<LinearLayout>(R.id.addtask)
        layoutAddTask.setOnClickListener {
            // Intent to start AddGoalActivity
            val intent = Intent(this, AddGoalActivity::class.java)
            startActivity(intent)
        }

        // Update page with placeholder data
        findViewById<TextView>(R.id.tvProgressValue).text = weeklyProgress
        findViewById<TextView>(R.id.tvStreak).text = streak.toString()
        findViewById<TextView>(R.id.tvLeaderboard).text = leaderboardPosition
        findViewById<TextView>(R.id.tvTasksCompleted).text = tasksCompleted.toString()
    }
}
