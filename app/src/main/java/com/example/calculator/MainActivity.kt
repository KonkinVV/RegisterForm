package com.example.calculator

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var ivPlus: ImageView
    lateinit var ivMinus: ImageView
    lateinit var etNumber1: EditText
    lateinit var etNumber2: EditText
    lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ivPlus = findViewById(R.id.iv_plus)
        ivMinus = findViewById(R.id.iv_minus)
        etNumber1 = findViewById(R.id.et_number1)
        etNumber2 = findViewById(R.id.et_number2)
        tvResult = findViewById(R.id.tv_result)

        ivPlus.setOnClickListener {
            if( handleNoInputData())
                return@setOnClickListener
            val number1 = etNumber1.text.toString().toBigDecimal()
            val number2 = etNumber2.text.toString().toBigDecimal()
            val sum = number1 + number2
            tvResult.text = sum.toString()
        }
        ivMinus.setOnClickListener {
            if( handleNoInputData())
                return@setOnClickListener
            val number1 = etNumber1.text.toString().toBigDecimal()
            val number2 = etNumber2.text.toString().toBigDecimal()
            val sum = number1 - number2
            tvResult.text = sum.toString()
        }
    }

    private fun handleNoInputData():Boolean{
        val number1Text = etNumber1.text.toString()
        val number2Text = etNumber2.text.toString()

        if (number1Text.isEmpty() || number2Text.isEmpty()){
            if(number1Text.isEmpty()){
                etNumber1.requestFocus()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(etNumber1, InputMethodManager.SHOW_IMPLICIT)
            } else {
                etNumber2.requestFocus()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(etNumber2, InputMethodManager.SHOW_IMPLICIT)
            }
            Toast.makeText(applicationContext, R.string.no_entered_text_toast, Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}
