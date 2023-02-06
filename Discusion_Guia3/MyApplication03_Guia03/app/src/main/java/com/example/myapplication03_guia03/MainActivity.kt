package com.example.myapplication03_guia03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var txtnumber1 : EditText
    private lateinit var txtnumber2 : EditText
    private lateinit var btnsumar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtnumber1 = findViewById<EditText>(R.id.idnumber1)
        txtnumber2 = findViewById<EditText>(R.id.idnumber2)
        btnsumar = findViewById<Button>(R.id.idbutton)

        btnsumar.setOnClickListener{
            var producto : Int
            var num1 : Int
            var num2 : Int
            num1 = Integer.parseInt(txtnumber1.text.toString().trim())
            num2 = Integer.parseInt(txtnumber2.text.toString().trim())
            producto = num1 + num2
            Toast.makeText(this, "La suma de ${num1} + ${num2} = ${producto}", Toast.LENGTH_SHORT).show()
        }

        lifecycle.addObserver(MyLifeCycleObserver())
        Toast.makeText(this,"onCreate", Toast.LENGTH_SHORT).show()
    }
    override fun onStart(){
        super.onStart()
        Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show()
    }
    override fun onResume(){
        super.onResume()
        Toast.makeText(this,"onResume", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }
    override fun onStop(){
        super.onStop()
        Toast.makeText(this,"onStop", Toast.LENGTH_SHORT).show()
    }
    override fun onRestart(){
        super.onRestart()
        Toast.makeText(this,"onRestart", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy(){
        super.onDestroy()
        Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show()
    }

}