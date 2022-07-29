package com.example.pyphagorcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pyphagorcalculator.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun omClickResult(view:View){
        if(!CheckVarEmpty()){
            val answer = getString(R.string.rresult_info) + getResult()
            binding.answer.text = answer
        }

    }
    private fun CheckVarEmpty() : Boolean{
        binding.apply {
            if(varA.text.isNullOrEmpty()) varA.error = "Не указана переменная а"
            if(varB.text.isNullOrEmpty()) varB.error = "Не указана переменная b"
            return varA.text.isNullOrEmpty() || varB.text.isNullOrEmpty()
        }
    }

    private fun getResult() : String{
        val a : Double
        val b : Double
        binding.apply {
            a = varA.text.toString().toDouble()
            b = varB.text.toString().toDouble()
            val result = sqrt((a.pow(2)) + (b.pow(2)))
            return result.toString()
        }
    }

}