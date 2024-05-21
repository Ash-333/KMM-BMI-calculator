package calculator.domain

fun BodyMeasurement.toBMI():Float{
    return this.weightKg/(this.heightFt*this.heightFt*0.0001f)
}