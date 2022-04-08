package io.github.manuelernesto.applecardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.manuelernesto.applecardapp.ui.theme.AppleCardAppTheme
import io.github.manuelernesto.applecardapp.ui.theme.Dark
import io.github.manuelernesto.applecardapp.ui.theme.White
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
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBg)
            .padding(16.dp)
    ) {
        MyTopBar()
    }
}



@Composable
fun MyTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Done", fontWeight = FontWeight.Bold, color = Dark)
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search),
                contentDescription = "Search Icon",
                tint = Dark
            )
            Spacer(modifier = Modifier.size(8.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Dark)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_more),
                    contentDescription = "more Icon",
                    tint = White
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppleCardAppTheme {
        Home()
    }
}