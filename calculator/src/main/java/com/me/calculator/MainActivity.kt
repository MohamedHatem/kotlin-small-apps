package com.me.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var op = "*"
    var oldNumber = ""
    var isNewOp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buNumberEvent(view: View) {

        if (isNewOp)
            etShowNumber.setText("")

        isNewOp = false

        val buSelected = view as Button

        var selectedBuVal: String = etShowNumber.text.toString()

        when (buSelected.id) {
            bu1.id -> selectedBuVal += "1"
            bu2.id -> selectedBuVal += "2"
            bu3.id -> selectedBuVal += "3"
            bu4.id -> selectedBuVal += "4"
            bu5.id -> selectedBuVal += "5"
            bu6.id -> selectedBuVal += "6"
            bu7.id -> selectedBuVal += "7"
            bu8.id -> selectedBuVal += "8"
            bu9.id -> selectedBuVal += "9"
            buDot.id -> selectedBuVal += "."
            buPlusMins.id -> {
                selectedBuVal = "-$selectedBuVal"
            }
            else -> "0"
        }

        etShowNumber.setText(selectedBuVal);

    }


    fun buOpEevent(view: View) {

        val buSelected = view as Button
        op = when (buSelected.id) {
            buDiv.id -> "/"
            buSub.id -> "-"
            buSum.id -> "+"
            else -> "*"
        }
        oldNumber = etShowNumber.text.toString()
        isNewOp = true
    }


    fun buEqualEvent(view: View) {
        val newNumber = etShowNumber.text.toString()
        var finalNumber = when (op) {
            "/" -> oldNumber.toDouble() / newNumber.toDouble()
            "+" -> oldNumber.toDouble() + newNumber.toDouble()
            "-" -> oldNumber.toDouble() * newNumber.toDouble()
            else -> oldNumber.toDouble() * newNumber.toDouble()
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun buPercent(view:View){
        val number:Double=etShowNumber.text.toString().toDouble()/100

        etShowNumber.setText(number.toString())
        isNewOp=true

    }

    fun buClean(view:View){
        etShowNumber.setText("0")
        isNewOp=true
    }

}
