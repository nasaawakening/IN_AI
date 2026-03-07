package com.inai.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(

    primary = Purple500,
    secondary = Teal200,
    background = Black,
    surface = Black

)

private val LightColorScheme = lightColorScheme(

    primary = Purple500,
    secondary = Teal200,
    background = White,
    surface = White

)

@Composable
fun INAITheme(

    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit

) {

    val colors = if (darkTheme) {

        DarkColorScheme

    } else {

        LightColorScheme

    }

    MaterialTheme(

        colorScheme = colors,
        typography = Typography,
        content = content

    )

}