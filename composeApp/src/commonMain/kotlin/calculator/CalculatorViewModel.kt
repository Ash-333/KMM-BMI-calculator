package calculator

import androidx.compose.ui.graphics.Color
import calculator.domain.BodyMeasurement
import calculator.domain.toBMI
import calculator.utils.roundUpToNearestHalfInteger
import calculator.utils.roundUpToNearestInteger
import calculator.utils.toBMIColor
import calculator.utils.toFormattedString
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState>
        get() = _uiState

    init{
        updateUIState(_uiState.value.bodyMeasurement)
    }

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.ChangeHeight -> {
                updateUIState(
                    _uiState.value.bodyMeasurement.copy(heightFt = event.heightFt)
                )
            }

            is UIEvent.ChangeWeight -> {
                updateUIState(
                    _uiState.value.bodyMeasurement.copy(weightKg = event.weightKg)
                )
            }
        }
    }

    private fun updateUIState(bodyMeasurement: BodyMeasurement) {
        _uiState.update { state ->
            val bmi = bodyMeasurement.toBMI()
            state.copy(
                bodyMeasurement = bodyMeasurement,
                bmiDisplay = bmi.toFormattedString(),
                heightDisplay = bodyMeasurement.heightFt.roundUpToNearestInteger().toString(),
                weightDisplay = bodyMeasurement.weightKg.roundUpToNearestHalfInteger().toString(),
                accentColor = bmi.toBMIColor()
                )
        }
    }

    sealed class UIEvent {
        data class ChangeWeight(val weightKg: Float) : UIEvent()
        data class ChangeHeight(val heightFt: Float) : UIEvent()
    }

    data class UIState(
        val bodyMeasurement: BodyMeasurement = BodyMeasurement(5.3f, 50f),
        val bmiDisplay: String = "",
        val heightDisplay: String = "",
        val weightDisplay: String = "",
        val accentColor: Color = Color.Blue

    )
}