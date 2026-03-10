package com.example.gonzalezpauandroidstudioact3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExercise11 = findViewById<Button>(R.id.button3);

        btnExercise11.setOnClickListener {
            val intent = Intent(this, Exercici11::class.java)
            startActivity(intent)

        }
        val btnExercise12 = findViewById<Button>(R.id.button4);

        btnExercise12.setOnClickListener{
            val intent = Intent( this, Exercici12::class.java)
            startActivity(intent)
        }
    }
}