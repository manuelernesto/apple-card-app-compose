package io.github.manuelernesto.applecardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.manuelernesto.applecardapp.ui.screen.CardDetail
import io.github.manuelernesto.applecardapp.ui.theme.AppleCardAppTheme
import io.github.manuelernesto.applecardapp.ui.theme.WhiteBg

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppleCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = WhiteBg
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    CardDetail()
}