package com.example.note_app_mvvm.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.note_app_mvvm.repository.models.TodoItem


@Composable
fun TodoItem(
    todo: TodoItem,
    onCheckedChanged: (Boolean) -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Checkbox(
            checked = todo.isChecked,
            onCheckedChange = onCheckedChanged
        )

        Column(modifier = Modifier.weight(1f)) {
            Text(todo.title, fontWeight = FontWeight.Bold)
            if (todo.description.isNotBlank()) {
                Text(todo.description, fontSize = 14.sp)
            }
        }

        Button(onClick = onDelete) {
            Text("Delete Todo")
        }
    }
}