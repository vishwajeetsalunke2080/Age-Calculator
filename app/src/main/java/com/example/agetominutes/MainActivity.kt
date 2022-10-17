package com.example.agetominutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var finalDisplay:TextView? = null
    private var userDateOfBirth :TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        finalDisplay = findViewById(R.id.displayInMinutes)
        userDateOfBirth = findViewById(R.id.userDateOfBirth)
        val buttonDisplay = findViewById<Button>(R.id.dateSelectionButton)
        buttonDisplay.setOnClickListener()
        {
            getDate()

        }
    }
    fun getDate(){
        val mycal = Calendar.getInstance()
        val cYear = mycal.get(Calendar.YEAR);
        val cMonths = mycal.get(Calendar.MONTH);
        val cDays = mycal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{view , year , months , day ->
                                          val selectedDate = "$day/${months+1}/$year"
                                          userDateOfBirth?.text = "Selected DoB:"+selectedDate.toString()
                                          val sdf = SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
                                          val bDate = sdf.parse(selectedDate)
                                          val inMills = bDate.time
                                          val inMinutes = inMills/60000

                                          val currDateInMills = sdf.parse(sdf.format(System.currentTimeMillis()))
                                          val currentTimeInMins = currDateInMills.time/60000
                                          val currentAgeInMin = currentTimeInMins - inMinutes
                                          finalDisplay?.text = "Your Age In Minutes is :" + currentAgeInMin
        },
        cYear,cMonths,cDays).show()

    }

}
