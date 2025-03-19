package com.example.note_app_mvvm.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.note_app_mvvm.repository.models.TodoItem

@Composable
fun Stats(todos: MutableList<TodoItem>) {
    val numberOfTodoItemsLeft = todos.filter{!it.isChecked}.size

    Text("Number of todos: ${todos.size}")
    Text("Todos left: $numberOfTodoItemsLeft")
}