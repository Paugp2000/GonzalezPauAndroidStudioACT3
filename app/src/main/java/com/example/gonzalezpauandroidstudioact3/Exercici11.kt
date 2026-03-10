package com.example.gonzalezpauandroidstudioact3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.Switch

class Exercici11 : AppCompatActivity() {
    // Declaració de les vistes
    private lateinit var scrollView: HorizontalScrollView
    private lateinit var toggleScroll: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercici11)

        // Connectar les vistes amb el XML
        scrollView = findViewById(R.id.horizontalScrollView)
        toggleScroll = findViewById(R.id.switchScroll)

        // Configurar l'escoltador del Switch
        toggleScroll.setOnCheckedChangeListener { _, isChecked ->
            // Si el switch està activat (true), mostrem les línies de scroll
            // Si està desactivat (false), les amaguem
            scrollView.isHorizontalScrollBarEnabled = isChecked
        }
    }
}