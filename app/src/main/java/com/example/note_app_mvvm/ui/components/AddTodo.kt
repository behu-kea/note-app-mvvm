package com.example.note_app_mvvm.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddTodo(
    titleText: String,
    descriptionText: String,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onAddNewTodo: () -> Unit
) {
    TextField(
        value = titleText,
        label = { Text("Title") },
        modifier = Modifier.fillMaxWidth(),
        onValueChange = onTitleChange
    )

    Spacer(modifier = Modifier.height(16.dp))

    TextField(
        value = descriptionText,
        label = { Text("Description") },
        modifier = Modifier.fillMaxWidth(),
        onValueChange = onDescriptionChange
    )

    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = onAddNewTodo) {
        Text("Add todo")
    }
}