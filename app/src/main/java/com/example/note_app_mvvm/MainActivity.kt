package com.example.note_app_mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note_app_mvvm.ui.components.AddTodo
import com.example.note_app_mvvm.ui.components.Stats
import com.example.note_app_mvvm.ui.components.Title
import com.example.note_app_mvvm.ui.components.TodoItem
import com.example.note_app_mvvm.ui.theme.NoteappmvvmTheme
import com.example.note_app_mvvm.ui.view_models.TodoViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<TodoViewModel>()

            NoteappmvvmTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Title()

                        Spacer(modifier = Modifier.height(24.dp))

                        AddTodo(
                            viewModel.titleText,
                            viewModel.descriptionText,
                            viewModel::onTitleChange,
                            viewModel::onDescriptionChange,
                            viewModel::onAddNewTodo
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        HorizontalDivider(thickness = 2.dp)

                        Spacer(modifier = Modifier.height(24.dp))

                        Stats(viewModel.todos)

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Todos",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Todo list
                        LazyColumn {
                            items(viewModel.todos) { todo ->
                                TodoItem(
                                    todo,
                                    onCheckedChanged = { isChecked ->
                                        viewModel.onCheckedChange(isChecked, todo)
                                    },
                                    onDelete = {
                                        viewModel.onDelete(todo)
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}
