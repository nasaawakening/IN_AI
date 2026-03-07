package com.inai.chat

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.inai.ai.ModelLoader

@Composable
fun CodeEditorScreen() {

    var code by remember { mutableStateOf("") }

    var aiResponse by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        Text(
            text = "Code Editor",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(10.dp))

        BasicTextField(
            value = code,
            onValueChange = { code = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            textStyle = TextStyle(
                color = Color.White
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row {

            Button(
                onClick = {

                    val clipboard =
                        context.getSystemService(
                            Context.CLIPBOARD_SERVICE
                        ) as ClipboardManager

                    val clip = ClipData.newPlainText(
                        "code",
                        code
                    )

                    clipboard.setPrimaryClip(clip)

                }
            ) {

                Text("Copy")

            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {

                    val prompt =
                        """
Analyze this code and explain or fix it:

$code
                        """.trimIndent()

                    ModelLoader.askAI(prompt) {

                        aiResponse = it

                    }

                }
            ) {

                Text("Ask AI")

            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "AI Response",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = aiResponse,
            color = Color.White
        )

    }

}