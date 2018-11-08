package com.example.jweirdkid.calculators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_tip.*



class TipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip)

        fun EditText.changer(){
            this.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    resultamountID?.text = calcTip()
                }

                override fun afterTextChanged(s: Editable) {

                }

            })

        }

        totalEdit.changer()
        tipEdit.changer()

    }

    fun calcTip() :String {

        //there's probably easier way to do this but couldnt find a way to convert it to double right away tried toDouble and parseDouble but
        // just couldnt understand why it wouldnt work
        val bill : String = if (totalEdit!!.text.isNotEmpty()) {
            totalEdit!!.text.toString()
        } else {
            "0"
        }

        val tip :String = if (tipEdit!!.text.isNotEmpty()) {
            tipEdit!!.text.toString()
        } else {

            "0"
        }

        val billDouble = bill.toDouble()
        val tipDouble = tip.toDouble()

        val convert = tipDouble /100
        val result = billDouble * convert


        return ("%.2f".format(result))

    }


}
