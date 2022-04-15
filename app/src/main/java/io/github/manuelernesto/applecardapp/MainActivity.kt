package io.github.manuelernesto.applecardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.manuelernesto.applecardapp.ui.theme.*
import kotlin.math.roundToInt

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

/*Card Detail Starts here*/

@Composable
fun MyTopBarDetail() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Cancel", fontWeight = FontWeight.Bold, color = Dark)
        Row {
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
@Composable
fun CardDetail() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBg)
            .padding(16.dp)
    ) {
        MyTopBarDetail()
        CircleBar()
    }
}
/*Card Detail  Ends here*/

/*Circular Starts here*/
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CircleBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val maxValue = 100f
        var value by remember {
            mutableStateOf(0f)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Choose Amount",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Make payment by 8:59 PM on April 20",
                fontSize = 18.sp,
                color = Color.Black
            )

            Slider(
                modifier = Modifier.width(150.dp),
                value = value,
                onValueChange = { value = it },
                valueRange = 0f..maxValue,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Black,
                    activeTrackColor = Color.Gray
                )
            )
        }

        CircularIndicator(indicatorValue = value, maxIndicatorValue = maxValue)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Pay April Balance",
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = "Paying your monthly balance is recommended to help keep you financially healthy and avoid interest changes.",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.size(36.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.LightGray
                )
            ) {
                Text(text = "Pay Later")
            }


            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Dark
                )
            ) {
                Text(text = "Pay Now")
            }
        }
    }

}

@Composable
fun CircularIndicator(
    canvasSize: Dp = 300.dp,
    indicatorValue: Float = 0f,
    maxIndicatorValue: Float = 100f,
    backgroundIndicatorColor: Color = MaterialTheme.colors.onSurface.copy(.1f),
    backgroundIndicatorStrokeWidth: Float = 70f,
    foregroundIndicatorColor: Color = Green,
    foregroundIndicatorStrokeWidth: Float = 70f,
) {

    val animatedIndicatorValue = remember {
        Animatable(initialValue = 0f)
    }
    LaunchedEffect(key1 = indicatorValue) {
        animatedIndicatorValue.animateTo(indicatorValue.toFloat())
    }
    val percentage = (animatedIndicatorValue.value / maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (3.6 * percentage).toFloat(),
        animationSpec = tween(1000)
    )

    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )
                foregroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor,
                    indicatorStrokeWidth = foregroundIndicatorStrokeWidth
                )
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Card Balance: $${maxIndicatorValue.round()}",
            fontSize = 18.sp,
            color = Color.Gray
        )
        Text(
            text = "$${indicatorValue.round()}",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 56.sp
        )
        Text(text = "Amount to Pay", fontSize = 18.sp, color = Color.LightGray)
    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 270f,
        sweepAngle = 360f,
        useCenter = false,
        style = Stroke(width = indicatorStrokeWidth, cap = StrokeCap.Round),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 270f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(width = indicatorStrokeWidth, cap = StrokeCap.Round),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

//startAngle = 270f,
/*Circular ends here*/

fun Float.round(): Float {
    return (this * 100.0f).roundToInt() / 100.0f
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppleCardAppTheme {
        CardDetail()
    }
}