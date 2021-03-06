package com.example.jweirdkid.calculators

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_gpa.*
import java.io.Serializable

private var courses = arrayListOf<Info> ()

data class Info(val course : String, val grade : String, val units : String) : Serializable

class GpaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gpa)
        val listView = findViewById<ListView>(R.id.prev_listview)

        listView.adapter = object : ArrayAdapter<Info>(this, R.layout.preview_row, R.id.prevClassTextView, courses) {
            private val mContext: Context = context

            override fun getCount(): Int {
                return courses.size

            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val layoutInflater = LayoutInflater.from(mContext)
                val previewRow = layoutInflater.inflate(R.layout.preview_row, parent, false)

                val courseTextView = previewRow.findViewById<TextView>(R.id.prevClassTextView)
                courseTextView.text = "Course: ${courses[position].course} Grade: ${courses[position].grade.toUpperCase()} Units: ${courses[position].units}"

                return previewRow
            }
        }

        addButtonID.setOnClickListener {
            val course: String = courseInput.text.toString()
            val grade: String = gradeInput.text.toString().toUpperCase()
            val unit: String = unitInput.text.toString()

            //check if the EditText have values or not
            if(course.isNotEmpty() && grade.isNotEmpty() && unit.isNotEmpty()) {

                if(grade == "A" || grade == "B" || grade == "C" || grade == "D" || grade == "F") {
                    val adapter: ArrayAdapter<Info> = listView.adapter as ArrayAdapter<Info>

                    adapter.add(Info(courseInput.text.toString(), gradeInput.text.toString(), unitInput.text.toString()))

                    courseInput.text.clear()
                    gradeInput.text.clear()
                    unitInput.text.clear()

                    val gpa = getGPA()
                    gpaCalc.text = gpa.toString()

                    adapter.notifyDataSetChanged()
                }
                else {
                    Toast.makeText(applicationContext, "Make sure grade is either A, B, C, D, F!", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(applicationContext, "Don't leave any fields blank!", Toast.LENGTH_SHORT).show()
            }

        }

    }
    fun getGPA() : Double {

        var unitInit : Double
        var unitsTotal = 0.0
        var grade = 0.0
        var gradepoints = 0.0

        for(i in courses.indices) {
            unitInit = courses[i].units.toDouble()
            unitsTotal += courses[i].units.toDouble()


            if(courses[i].grade.toUpperCase() == "A")
            {
                grade = 4.0
            }
            else if(courses[i].grade.toUpperCase() == "B")
            {
                grade = 3.0
            }
            else if(courses[i].grade.toUpperCase() == "C")
            {
                grade = 2.0
            }
            else if(courses[i].grade.toUpperCase() == "D")
            {
                grade = 1.0
            }
            else if(courses[i].grade.toUpperCase() == "F")
            {
                grade = 0.0
            }

            gradepoints += unitInit * grade
        }

        //add decimal places
        val gpa = gradepoints / unitsTotal

        return ("%.2f".format(gpa)).toDouble()
    }
}

