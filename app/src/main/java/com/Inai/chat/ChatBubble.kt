package com.inai.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChatBubble(
    message: String,
    isUser: Boolean
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
        if (isUser) Arrangement.End else Arrangement.Start
    ) {

        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(
                    color = if (isUser)
                        MaterialTheme.colorScheme.primary
                    else
                        Color(0xFF2A2A2A),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
        ) {

            Text(
                text = message,
                color = Color.White
            )

        }

    }

}