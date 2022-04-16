package io.github.manuelernesto.applecardapp.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.manuelernesto.applecardapp.ui.theme.Dark
import io.github.manuelernesto.applecardapp.ui.theme.Gray

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
                    activeTrackColor = Gray
                )
            )
        }

        CircularIndicator(
            indicatorValue = value,
            maxIndicatorValue = maxValue
        )

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
