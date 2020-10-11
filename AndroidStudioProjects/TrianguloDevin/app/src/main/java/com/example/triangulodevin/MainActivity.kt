package com.example.triangulodevin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
    var primerLado = ladoA.text.toString().toDouble()
    var segundoLado = ladoB.text.toString().toDouble()
    var sumaPotencia = ((segundoLado)*(segundoLado))+((primerLado)*(primerLado))
    var raiz: Double = sqrt(sumaPotencia)
    textView5.setText(raiz.toString())


    }
}