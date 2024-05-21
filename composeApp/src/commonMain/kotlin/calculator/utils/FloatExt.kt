package calculator.utils

import androidx.compose.ui.graphics.Color
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.round

fun Float.roundUpToNearestInteger():Int=(this+0.5f).toInt()

fun Float.roundUpToNearestHalfInteger():Int=(this*2f).roundToInt()

fun Float.toFormattedString(decimals:Int=2):String{
    val multiplier=10.toFloat().pow(decimals)
    val rounded=round(this*multiplier)/multiplier
    return rounded.toString()
}

fun Float.toBMIColor(): Color {
    if(this<18.5f){
        return Color(0xFF00CEE6)
    }
    else if(this<25.0f){
        return Color(0xFF96CD3E)
    }
    else if(this<30.0f){
        return Color(0xFFF4BD40)
    }
    else if(this<35.0f){
        return Color(0xFFEE7D29)
    }
    else if(this<40.0f){
        return Color(0xFFED5321)
    }
    return Color(0xFFED5321)
}