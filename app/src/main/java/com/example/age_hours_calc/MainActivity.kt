package com.example.age_hours_calc

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import java.util.*
import android.app.DatePickerDialog
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)

    private var dob : TextView? = null

    private var age : TextView? = null


    @SuppressLint("CutPasteId")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn)

        dob = findViewById(R.id.dob)

        age = findViewById(R.id.AgeInHours)

        btn.setOnClickListener {
            clickDatePicker()
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog( this,
            { view, SelectedYear, SelectedMonth, SelectedDayOfMonth ->

                Toast.makeText(this, "The DOB is selected", Toast.LENGTH_SHORT).show()

                val selectedDate = "$SelectedDayOfMonth/${SelectedMonth + 1}/$SelectedYear"
                dob?.text= (selectedDate)
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                val SelectedAgeInHours = (theDate.time) / 3600000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val CurrentAgeInHours = currentDate.time / 3600000
                val DifferenceInHours = CurrentAgeInHours - SelectedAgeInHours
                age?.text = (DifferenceInHours).toString()

            },
                year, month, day).show()
    }

}
