package calculator.components

import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MeasurementSliderView(
    min:Float,
    max:Float,
    steps:Int,
    sliderPositions: Float,
    onPositionUpdate:(Float)->Unit
) {
    Slider(
        value=sliderPositions,
        valueRange=min..max,
        steps=steps,
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Blue
        ),
        onValueChange = {
            onPositionUpdate(it)
        }
    )
}
