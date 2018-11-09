package com.example.jweirdkid.calculators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_bmi.*
import java.lang.Exception


// inspiration
// https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm
class BmiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        fun EditText.checkForChange() {
            this.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable) {
                    try {
                        if (s != null && s.isNotEmpty()) {
                            bmiTotalTextView.text = getBMI()
                        }
                    } catch(e: Exception) {
                    }
                }
            })
        }
        feetInput.checkForChange()
        inchesInput.checkForChange()
        poundsInput.checkForChange()

    }

    fun getBMI() : String {

        // https://www.cdc.gov/healthyweight/assessing/bmi/childrens_bmi/childrens_bmi_formula.html
        //Formula: 703 x weight (lbs) / [height (in)]^2

        val feet = feetInput.text.toString()
        val inches = inchesInput.text.toString()
        val pounds = poundsInput.text.toString()
        val conversionNum = 703.0
        val heightInInches = (feet.toDouble() * 12.0) + inches.toDouble()

        val bmi = conversionNum * pounds.toDouble() /  Math.pow(heightInInches, 2.0)

        return String.format("%.1f", bmi)
    }
}
