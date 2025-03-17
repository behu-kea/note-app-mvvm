package com.example.note_app_mvvm.ui.repository.models

data class TodoItem(
    val title: String,
    val description: String,
    var isChecked: Boolean = false
)