package io.github.manuelernesto.applecardapp.ui.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.manuelernesto.applecardapp.ui.theme.Green
import io.github.manuelernesto.applecardapp.ui.theme.Orange
import io.github.manuelernesto.applecardapp.ui.theme.Red
import io.github.manuelernesto.applecardapp.util.round

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

    var animatedIndicatorValue by remember { mutableStateOf(0f) }

    LaunchedEffect(key1 = indicatorValue) {
        animatedIndicatorValue = indicatorValue
    }
    val percentage = (animatedIndicatorValue / maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (3.6 * percentage).toFloat(),
        animationSpec = tween(1000)
    )

    val receivedValue by animateFloatAsState(
        targetValue = indicatorValue,
        animationSpec = tween(100)
    )

    val animateCenterTextColor by animateColorAsState(
        targetValue = if (receivedValue == 0.0f)
            MaterialTheme.colors.onSurface.copy(alpha = .3f)
        else Color.Black, animationSpec = tween(1000)
    )
    val animateCircleColor by animateColorAsState(
        targetValue = when {
            receivedValue <= 50 -> Green
            receivedValue <= 75 -> Orange
            else -> Red
        },
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
                    indicatorColor = animateCircleColor,
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
            text = "$${receivedValue.round()}",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 56.sp,
            color = animateCenterTextColor
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
