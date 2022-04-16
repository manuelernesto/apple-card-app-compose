package io.github.manuelernesto.applecardapp.util

import kotlin.math.roundToInt

fun Float.round(): Float {
    return (this * 100.0f).roundToInt() / 100.0f
}
