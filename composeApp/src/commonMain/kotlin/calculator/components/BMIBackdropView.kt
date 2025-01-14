package calculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BMIBackdropView(modifier: Modifier=Modifier,color:Color) {
    Box(modifier=modifier.background(color))
}

@Preview
@Composable
fun BMIBackDropViewPreview(){
    BMIBackdropView(modifier = Modifier.fillMaxSize(),Color.Red)
}