package com.inai.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.inai.ai.OllamaClient

data class Message(
    val text: String,
    val isUser: Boolean
)

@Composable
fun ChatScreen() {

    var input by remember { mutableStateOf("") }

    var messages by remember {
        mutableStateOf(listOf<Message>())
    }

    Column {

        TopAppBar(
            title = { Text("IN_AI") }
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(messages) { msg ->

                ChatBubble(
                    message = msg.text,
                    isUser = msg.isUser
                )

            }

        }

        Row {

            TextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {

                    if (input.isNotEmpty()) {

                        val userMsg = Message(input, true)

                        messages = messages + userMsg

                        val prompt = buildPrompt(messages)

                        input = ""

                        OllamaClient.ask(prompt) { reply ->

                            messages =
                                messages + Message(reply, false)

                        }

                    }

                }
            ) {

                Text("Send")

            }

        }

    }

}

fun buildPrompt(messages: List<Message>): String {

    val builder = StringBuilder()

    builder.append(
        "You are IN_AI coding assistant.\n"
    )

    for (msg in messages) {

        if (msg.isUser) {
            builder.append("User: ${msg.text}\n")
        } else {
            builder.append("AI: ${msg.text}\n")
        }

    }

    builder.append("AI:")

    return builder.toString()
}