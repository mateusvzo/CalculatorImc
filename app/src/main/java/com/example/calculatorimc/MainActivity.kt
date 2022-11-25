package com.example.calculatorimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateImc(view: View){

        val userWeight = userWeight.text.toString()
        val userHeight = userHeight.text.toString()

        val fieldValidate = fieldValidation(userWeight, userHeight)

        if(fieldValidate) {
            calculateUserImc(userWeight, userHeight)
        }

    }

    fun fieldValidation(userWeight: String, userHeight: String): Boolean {

        var validate = true
        if(userWeight == null || userWeight.equals("")){
            validate = false
        } else if(userHeight == null || userHeight.equals("")){
            validate = false
        }

        return validate
    }

    fun calculateUserImc(userWeight: String, userHeight: String){

        var weight = userWeight.toDouble()
        var height = userHeight.toDouble()

        var result = weight / (height.pow(2))
        var formattedResult: Double = String.format("%.1f", result).toDouble()


        if(result < 18.5){
            userResult.text = "Seu IMC é $formattedResult classificado como 'Magreza'"
        } else if(result >= 18.5 && result <= 24.9){
            userResult.text = "Seu IMC é $formattedResult classificado como 'Normal'"
        } else if(result >= 25 && result <=29.9){
            userResult.text = "Seu IMC é $formattedResult classificado como 'Sobrepeso'"
        } else if(result >= 30 && result <=34.9){
            userResult.text = "Seu IMC é $formattedResult classificado como 'Obesidade grau I'"
        } else if(result >= 35 && result <= 39.9){
            userResult.text = "Seu IMC é $formattedResult classificado como 'Obesidade grau II'"
        } else {
            userResult.text = "Seu IMC é $formattedResult classificado como 'Obesidade grau III'"
        }
    }
}