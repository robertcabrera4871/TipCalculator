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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tipInputView.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
               if(tipInputView.text.toString() != "") {
                    tip = 0.0
                    total = 0.0
                    tipPercentInput = tipInputView.text.toString().toDouble()
                    calculateAndUpdate()
               }
            }
        })
        totalInputView.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(totalInputView.text.toString() != "")
                {
                    tip = 0.0
                    total = 0.0
                    totalInput = totalInputView.text.toString().toDouble()
                    calculateAndUpdate()
                }
            }

        })
    }
    fun  calculateAndUpdate(){
        if(tipInputView.text.toString() != "" && totalInputView.text.toString() != ""){
            tip = totalInput * (tipPercentInput / 100.0)
            total += totalInput + tip
            tipAmountText.text = getString(R.string.tip).plus(round(tip * 100.0) / 100.0)
            totalAmountText.text = getString(R.string.total).plus(round(total * 100.0) / 100.0)
        }
    }
    /*
    Handles adding tip and changing tip and total views
    fun tipButtonClicked(view: View){
    val tipPercent: Double = determineTip(view)
    if(totalInputView.text.toString() != "") {

    val totalInput: Double = totalInputView.text.toString().toDouble()
    val tip = totalInput * tipPercent
    val total = totalInput + tip

    tipAmountText.text = getString(R.string.tip).plus(tip)
    totalAmountText.text = getString(R.string.total).plus(total)
    }
    }
    Compares the given button's ID to find button, returns corresponding percent
    Tried to make doubles resource, didn't work, ask in class.
    No longer using buttons
    private fun determineTip(view: View): Double{
    when(view.id){
    fifteenTipButton.id -> return 0.15
    twentyTipButton.id -> return 0.20
    twentyFiveTipButton.id -> return 0.25
    }
    return 0.0
    }
    */
}
