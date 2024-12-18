package com.example.taskhero2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddGoalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_goal_activity)

        val goalNameEditText = findViewById<TextInputEditText>(R.id.editTextGoalName)
        val goalDescriptionEditText = findViewById<TextInputEditText>(R.id.editTextGoalDescription)
        val goalDateEditText = findViewById<TextInputEditText>(R.id.editTextGoalDate)
        val submitButton = findViewById<Button>(R.id.buttonSubmitGoal)
        val btnHome = findViewById<Button>(R.id.btnhome)

        btnHome.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        val db = AppDatabase.getDatabase(this)

        submitButton.setOnClickListener {
            val goalName = goalNameEditText.text.toString().trim()
            val goalDescription = goalDescriptionEditText.text.toString().trim()
            val goalDate = goalDateEditText.text.toString().trim()

            if (goalName.isNotEmpty() && goalDescription.isNotEmpty() && goalDate.isNotEmpty()) {
                val newGoal = Goal(name = goalName, description = goalDescription, completeBy = goalDate)

                lifecycleScope.launch(Dispatchers.IO) {
                    try {
                        db.goalDao().insert(newGoal) // Insert the new goal
                        // Fetch to confirm insertion
                        val goals = db.goalDao().getAllGoals()
                        Log.d("AddGoalActivity", "Goals after insertion: $goals")

                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@AddGoalActivity, "Goal Added Successfully: $goalName", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@AddGoalActivity, "Failed to add goal: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
