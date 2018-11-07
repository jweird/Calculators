package com.example.jweirdkid.calculators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_tip.*
import kotlinx.android.synthetic.main.activity_tip.view.*


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

        val bill = if (totalEdit!!.text.isNotEmpty()) {
            Integer.parseInt(totalEdit!!.text.toString())
        } else {
            0
        }

        val tip = if (tipEdit!!.text.isNotEmpty()) {
            Integer.parseInt(tipEdit!!.text.toString())
        } else {

            0
        }

        val convert : Double = tip.toDouble() /100
        val result = bill * convert


        return ("%.1f".format(result))

    }


}
