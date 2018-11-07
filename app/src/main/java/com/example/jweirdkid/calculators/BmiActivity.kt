package com.example.jweirdkid.calculators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bmi.*

class BmiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        calculateButton.setOnClickListener {
            if(feetInput.text.isNotEmpty() && inchesInput.text.isNotEmpty() && poundsInput.text.isNotEmpty()) {
                val bmi = getBMI()

                bmiTotalTextView.text = bmi.toString()
            }
            else {
                Toast.makeText(applicationContext, "Don't leave any fields blank!", Toast.LENGTH_SHORT).show()
            }
        }

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
