package com.example.jweirdkid.calculators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_sales.*

class SalesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales)

        fun EditText.changer(){
            this.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    salesResult?.text = calcTax()
                }

                override fun afterTextChanged(s: Editable) {

                }

            })

        }

        amountInput.changer()
        taxAmountID.changer()

    }

    fun calcTax() :String {

        val amount : String = if (amountInput!!.text.isNotEmpty()) {
            amountInput!!.text.toString()
        } else {
            "0"
        }

        val tax = if (taxAmountID!!.text.isNotEmpty()) {
           taxAmountID!!.text.toString()
        } else {

            "0"
        }

        val amountDouble = amount.toDouble()
        val taxAmount : Double = (tax.toDouble() / 100) * amountDouble

        val result = amountDouble + taxAmount


        return ("%.2f".format(result))

    }


}
