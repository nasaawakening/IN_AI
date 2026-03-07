package com.inai.chat

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ChatBubble(
    message: String,
    isUser: Boolean
) {

    val context = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
        if (isUser) Arrangement.End else Arrangement.Start
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
                .background(
                    if (isUser)
                        MaterialTheme.colorScheme.primary
                    else
                        Color(0xFF2A2A2A),
                    RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
        ) {

            Text(
                text = message,
                color = Color.White
            )

            if (!isUser) {

                Spacer(modifier = Modifier.height(6.dp))

                Button(
                    onClick = {

                        val clipboard =
                            context.getSystemService(
                                Context.CLIPBOARD_SERVICE
                            ) as ClipboardManager

                        val clip = ClipData.newPlainText(
                            "AI",
                            message
                        )

                        clipboard.setPrimaryClip(clip)

                    }
                ) {

                    Text("Copy")

                }

            }

        }

    }

}