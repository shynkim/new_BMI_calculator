package com.example.new_bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ResultActivity : AppCompatActivity() {
    lateinit var resultTextView: TextView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultTextView=findViewById(R.id.resultTextView)
        imageView=findViewById(R.id.imageView)
        var height= intent.getStringExtra("height")!!.toInt()
        var weight=intent.getStringExtra("weight")!!.toInt()
        var bmi=weight/Math.pow(height/100.0,2.0)

        when{
            bmi>=35 -> resultTextView.text="고도 비만"
            bmi>=30 -> resultTextView.text="2단계 비만"
            bmi>=25 -> resultTextView.text="1단계 비만"
            bmi>=23 -> resultTextView.text="과체중"
            bmi>=10.5 -> resultTextView.text="정상"
            else -> resultTextView.text="저체중"
        }
        when{
            bmi>=35 -> imageView.setImageResource(R.drawable.sad)
            else -> imageView.setImageResource(R.drawable.smile)
        }
        Toast.makeText(this,"$bmi",Toast.LENGTH_SHORT).show()
    }
}