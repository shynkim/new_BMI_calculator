package com.example.new_bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var resultButton: Button
    lateinit var nameEditText: EditText
    lateinit var heightEditText: EditText
    lateinit var weightEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultButton=findViewById(R.id.resultButton)
        nameEditText=findViewById(R.id.nameEditText)
        heightEditText=findViewById(R.id.heightEditText)
        weightEditText=findViewById(R.id.weightEditText)
        loadData()
        resultButton.setOnClickListener{
            saveData(nameEditText.text.toString(), heightEditText.text.toString().toInt(),heightEditText.text.toString().toInt())
            var intent= Intent(this, ResultActivity::class.java)
            intent.putExtra("name",heightEditText.text.toString())
            intent.putExtra("height",heightEditText.text.toString())
            intent.putExtra("weight",weightEditText.text.toString())
            startActivity(intent)
        }
    }

    private fun saveData(name:String, height:Int, weight:Int){
        val pref=this.getPreferences(0)
        val editor=pref.edit()

        editor.putString("KEY_NAME",nameEditText.text.toString()).apply()
        editor.putInt("KEY_HEIGHT",heightEditText.text.toString().toInt()).apply()
        editor.putInt("KEY_WEIGHT",weightEditText.text.toString().toInt()).apply()
    }
    private fun loadData(){
        val pref=this.getPreferences(0)
        var name=pref.getString("KEY_NAME",null)
        var height=pref.getInt("KEY_HEIGHT",0)
        var weight=pref.getInt("KEY_WEIGHT",0)
        if(name!=null&&height!=0&&weight!=0){
            nameEditText.setText(name.toString())
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }
}