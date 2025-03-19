package com.example.note_app_mvvm.ui.view_models

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.note_app_mvvm.repository.models.TodoItem


class TodoViewModel: ViewModel() {
    var titleText by mutableStateOf("")
    var descriptionText by mutableStateOf("")
    var todos = mutableStateListOf<TodoItem>()

    fun onCheckedChange(isChecked: Boolean, todo: TodoItem) {
        val todoItemIndex = todos.indexOf(todo)
        if (todoItemIndex != -1) {
            todos[todoItemIndex] = todo.copy(isChecked = isChecked) // Trigger recomposition
        }
    }

    fun onTitleChange(newTitle: String) {
        titleText = newTitle
    }

    fun onDescriptionChange(newDescription: String) {
        descriptionText = newDescription
    }

    fun onAddNewTodo() {
        if (titleText.isNotBlank()) {
            todos.add(TodoItem(titleText, descriptionText))
            titleText = ""
            descriptionText = ""
        }
    }

    fun onDelete(todoItem: TodoItem) {
        todos.remove(todoItem)
    }
}
