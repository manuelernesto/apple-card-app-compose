package io.github.manuelernesto.applecardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.manuelernesto.applecardapp.ui.composables.CircleBar
import io.github.manuelernesto.applecardapp.ui.screen.CardDetail
import io.github.manuelernesto.applecardapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppleCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = WhiteBg
                ) {
                    CardDetail()
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
        CreditCard()
        CircleBar()
        //Activities()
    }
}

@Composable
fun Activities() {
    Spacer(modifier = Modifier.size(16.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(Orange),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                elevation = 0.dp,
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(5.dp)) {
                    Text(text = "Card Balance", color = Dark)
                    Text(
                        text = "$1,682.55", fontWeight = FontWeight.Bold, color = Dark,
                        fontSize = 20.sp
                    )
                    Text(text = "$8,317.45 Available", color = Color.LightGray)
                }
            }
            Card(
                elevation = 0.dp,
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(5.dp)) {
                    Text(text = "Weekly Activity", color = Dark)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(.4f)
                .fillMaxHeight()
        ) {
            Text(text = "2A")
            Text(text = "2B")
            Text(text = "2C")
        }
    }
}

@Composable
fun CreditCard() {
    Spacer(modifier = Modifier.size(16.dp))

    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(228.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.card),
            contentDescription = "Credit card",
            modifier = Modifier.fillMaxSize()
        )

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
        CardDetail()
    }
}