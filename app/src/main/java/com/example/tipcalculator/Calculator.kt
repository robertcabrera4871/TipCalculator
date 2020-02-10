package com.example.tipcalculator

import kotlin.math.round

class Calculator{
var tipPercentInput: Double = 0.0
var totalInput: Double = 0.0
var tip: Double = 0.0
var total: Double = 0.0

    fun calculateAndUpdate() {
        tip = totalInput * (tipPercentInput / 100.0)
        tip = (round(tip * 100.0) / 100.0)
        total += totalInput + tip
        total = (round(total * 100.0) / 100.0)
    }
}
