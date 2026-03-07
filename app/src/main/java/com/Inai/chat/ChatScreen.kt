package com.inai.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun ChatScreen() {

    var input by remember { mutableStateOf("") }

    Column {

        TopAppBar(
            title = { Text("IN_AI") }
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

        }

        Row {

            TextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = { }
            ) {

                Text("Send")

            }

        }

    }

}