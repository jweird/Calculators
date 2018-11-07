package com.example.jweirdkid.calculators

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gpaButton.setOnClickListener {

            val intent = Intent(this@MainActivity, GpaActivity::class.java)
            startActivity(intent)

        }

        salesButton.setOnClickListener {

            val intent = Intent(this@MainActivity, SalesActivity::class.java)
            startActivity(intent)

        }

        bmiButton.setOnClickListener {

            val intent = Intent(this@MainActivity, BmiActivity::class.java)
            startActivity(intent)

        }

        tipButton.setOnClickListener {

            val intent = Intent(this@MainActivity, TipActivity::class.java)
            startActivity(intent)

        }


    }


}
