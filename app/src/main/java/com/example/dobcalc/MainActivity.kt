package com.example.dobcalc

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.layout)

            val btnDatePicker  = findViewById<Button>(R.id.buttonDatePicker)

            val view1:TextView=findViewById(R.id.textView3);
            val view2:TextView=findViewById(R.id.textView5);

            btnDatePicker.setOnClickListener {
              clickDatePicker(view1,view2)
            }
        }
    }

    fun clickDatePicker(view1: TextView, view2: TextView) {

        val myCalender=Calendar.getInstance()
        val year=myCalender.get(Calendar.YEAR)
        val month=myCalender.get(Calendar.MONTH)
        val day=myCalender.get(Calendar.DAY_OF_MONTH)

       val dpd= DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{ view,Selectedyear,Selectedmonth,SelecteddayofMonth ->


                val selectedDate="$SelecteddayofMonth/${Selectedmonth+1}/${Selectedyear}"
                view1.text=selectedDate
                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate=sdf.parse(selectedDate)

                val selectedDateInMinutes=theDate.time/60000

                val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes= currentDate.time/60000

                val differenceInMinutes=currentDateInMinutes-selectedDateInMinutes

              view2.text= differenceInMinutes.toString()
            },
            year,
            month,
            day)

        dpd.show()

    }
}
