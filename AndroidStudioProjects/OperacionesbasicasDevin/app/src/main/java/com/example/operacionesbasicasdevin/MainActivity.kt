package com.example.operacionesbasicasdevin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Suma(view: View) {
        var num1 = numero1.text.toString().toDouble()
        var num2= numero2.text.toString().toDouble()
        var suma= num1 + num2
        resultado.setText(suma.toString())
    }

    fun Resta(view: View) {
        var num1 = numero1.text.toString().toDouble()
        var num2= numero2.text.toString().toDouble()
        var resta= num1 - num2
        resultado.setText(resta.toString())
    }

    fun Multi(view: View) {
        var num1 = numero1.text.toString().toDouble()
        var num2= numero2.text.toString().toDouble()
        var multi= num1 * num2
        resultado.setText(multi.toString())
    }
    fun division(view: View) {
        var num1 = numero1.text.toString().toDouble()
        var num2= numero2.text.toString().toDouble()
        var division= num1 / num2
        resultado.setText(division.toString())
    }
}