package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //Handles adding tip and changing tip and total views
    fun tipButtonClicked(view: View){
        var tipPercent: Double = determineTip(view)
        if(totalInputView.text.toString() != "") {

            var totalInput: Double = totalInputView.text.toString().toDouble()
            var tip = totalInput * tipPercent
            var total = totalInput + tip

            tipAmountText.text = getString(R.string.tip).plus(tip)
            totalAmountText.text = getString(R.string.total).plus(total)
        }
    }
    //Compares the given button's ID to find button, returns corresponding percent
    //Tried to make doubles resource, didn't work, ask in class.
    private fun determineTip(view: View): Double{
        when(view.id){
            fifteenTipButton.id -> return 0.15
            twentyTipButton.id -> return 0.20
            twentyFiveTipButton.id -> return 0.25
        }
        return 0.0
    }
}
