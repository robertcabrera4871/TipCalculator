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
*/
    var tipCalculator: Calculator = Calculator()

    inner class MyTextWatcher : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (tipInputView.text.toString() != "" && totalInputView.text.toString() != "" && !totalInputView.text.toString().startsWith(
                    '.'
                )
            ) {
                tipCalculator.tip = 0.0
                tipCalculator.total = 0.0
                tipCalculator.tipPercentInput = tipInputView.text.toString().toDouble()
                tipCalculator.totalInput = totalInputView.text.toString().toDouble()
                tipCalculator.calculateAndUpdate()
                tipAmountText.text = getString(R.string.tip).plus(round(tipCalculator.tip * 100.0) / 100.0)
                totalAmountText.text = getString(R.string.total).plus(round(tipCalculator.total * 100.0) / 100.0)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tipInputView.addTextChangedListener(MyTextWatcher())
        totalInputView.addTextChangedListener(MyTextWatcher())
    }
}

