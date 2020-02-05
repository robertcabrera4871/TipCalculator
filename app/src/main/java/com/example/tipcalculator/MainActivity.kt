package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.round
class MainActivity : AppCompatActivity() {

    /*
Tip Calculator takes price and finds user given tip
total given. Adds that tip to the total
Need to add rounding on calculations.
*/
    var tipPercentInput: Double = 0.0
    var totalInput: Double = 0.0
    var tip: Double = 0.0
    var total: Double = 0.0

    inner class MyTextWatcher : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (tipInputView.text.toString() != "" && totalInputView.text.toString() != "" && !totalInputView.text.toString().startsWith('.')) {
                tip = 0.0
                total = 0.0
                tipPercentInput = tipInputView.text.toString().toDouble()
                totalInput = totalInputView.text.toString().toDouble()
                calculateAndUpdate()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tipInputView.addTextChangedListener(MyTextWatcher())
        totalInputView.addTextChangedListener(MyTextWatcher())
    }

    fun calculateAndUpdate() {
            tip = totalInput * (tipPercentInput / 100.0)
            total += totalInput + tip
            tipAmountText.text = getString(R.string.tip).plus(round(tip * 100.0) / 100.0)
            totalAmountText.text = getString(R.string.total).plus(round(total * 100.0) / 100.0)
        }
    }
