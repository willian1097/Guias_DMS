package com.example.discusion_practica02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat


class MainActivity: AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val digit1=findViewById<EditText>(R.id.txtnumber1)
                val digit2=findViewById<EditText>(R.id.txtnumber2)
                val result=findViewById<TextView>(R.id.txtresultado)
                val btn=findViewById<Button>(R.id.btnenviar)

                btn.setOnClickListener{
                        result.setText(
                                "El resultado es: "+(digit1.text.toString().toDouble()+digit2.text.toString().toDouble())
                        )
                }

        }
        }
