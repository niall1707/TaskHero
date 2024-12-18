package com.example.taskhero2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.taskhero2.Goal
import kotlinx.coroutines.*

class GoalAdapter(context: Context, private var goals: List<Goal>) :
    ArrayAdapter<Goal>(context, 0, goals) {

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_goal, parent, false)
        val goal = getItem(position)

        val textViewGoal = itemView.findViewById<TextView>(R.id.textViewGoal)
        val buttonUpdate = itemView.findViewById<Button>(R.id.buttonUpdate)
        val buttonDone = itemView.findViewById<Button>(R.id.buttonDone)

        textViewGoal.text = "${goal?.name} - ${goal?.description}"

        buttonUpdate.setOnClickListener {
            // Update task name interaction
            promptUpdate(goal)
        }

        //internet reserch
        buttonDone.setOnClickListener {
            goal?.let {
                remove(it)
                notifyDataSetChanged()
                CoroutineScope(Dispatchers.IO).launch {
                    AppDatabase.getDatabase(context).goalDao().delete(goal)
                }
            }
        }

        return itemView
    }

    private fun promptUpdate(goal: Goal?) {
        goal?.let {
            // Implement dialog to input new name, then update database
            // Update code here
        }
    }
}
