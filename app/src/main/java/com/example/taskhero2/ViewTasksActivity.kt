package com.example.taskhero2

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.taskhero2.AppDatabase
import kotlinx.coroutines.*

class ViewTasksActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: GoalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_tasks)

        listView = findViewById(R.id.lvTasks)
        loadGoals()
    }

    private fun loadGoals() {
        CoroutineScope(Dispatchers.IO).launch {
            val goals = AppDatabase.getDatabase(applicationContext).goalDao().getAllGoals()
            withContext(Dispatchers.Main) {
                adapter = GoalAdapter(this@ViewTasksActivity, goals)
                listView.adapter = adapter
            }
        }
    }
}
