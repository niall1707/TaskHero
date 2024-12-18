package com.example.taskhero2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_fragment)

        val btnAddGoal = findViewById<Button>(R.id.btnAddGoal)
        btnAddGoal.setOnClickListener {
            // Navigate to Add Goal Activity
            val intent = Intent(this, AddGoalActivity::class.java)
            startActivity(intent)
        }

        val btnViewTasks = findViewById<Button>(R.id.btnViewTasks)
        btnViewTasks.setOnClickListener {
            // Navigate to View Tasks Activity
            val intent = Intent(this, ViewTasksActivity::class.java)
            startActivity(intent)
        }

        val btnViewProgress = findViewById<Button>(R.id.btnViewProgress)
        btnViewProgress.setOnClickListener {
            // Navigate to Progress Page Activity
            val intent = Intent(this, ProgressActivity::class.java)
            startActivity(intent)
        }
    }
}



