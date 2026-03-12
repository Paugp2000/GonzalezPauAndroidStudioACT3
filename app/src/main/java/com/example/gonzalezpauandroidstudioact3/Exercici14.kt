package com.example.gonzalezpauandroidstudioact3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Exercici14 : AppCompatActivity() {

    private var tvResult: TextView? = null
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0
    private var operation: String? = null
    private var isNewInput: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercici14)


        // Inicialitzar vistes
        tvResult = findViewById(R.id.tvResult)

        // Assignar listeners als botons
        setupNumberButtons()
        setupOperatorButtons()
        setupEqualsButton()
        setupClearButton()

    }
    // Configurar botons de números
    private fun setupNumberButtons() {
        val numberButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9
        )

        for (id in numberButtons) {
            findViewById<Button>(id).setOnClickListener {
                val button = findViewById<Button>(id)
                val number = button.text.toString()

                if (isNewInput) {
                    tvResult?.text = number
                    isNewInput = false
                } else {
                    tvResult?.text = tvResult?.text.toString() + number
                }
            }
        }
    }

    // Configurar botons d'operadors
    private fun setupOperatorButtons() {
        // Botó +
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            performOperation("+")
        }

        // Botó -
        findViewById<Button>(R.id.btnSubtract).setOnClickListener {
            performOperation("-")
        }

        // Botó x
        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            performOperation("x")
        }

        // Botó /
        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            performOperation("/")
        }
    }

    // Realitzar l'operació
    private fun performOperation(op: String) {
        try {
            firstNumber = tvResult?.text.toString().toDouble()
            operation = op
            isNewInput = true
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Error en el número", Toast.LENGTH_SHORT).show()
        }
    }

    // Configurar botó =
    private fun setupEqualsButton() {
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            try {
                secondNumber = tvResult?.text.toString().toDouble()

                val result = when (operation) {
                    "+" -> firstNumber + secondNumber
                    "-" -> firstNumber - secondNumber
                    "x" -> firstNumber * secondNumber
                    "/" -> if (secondNumber != 0.0) firstNumber / secondNumber
                    else {
                        Toast.makeText(this, "Divisió per zero!", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    else -> secondNumber
                }

                tvResult?.text = result.toString()
                firstNumber = result
                operation = null
                isNewInput = true

            } catch (e: Exception) {
                Toast.makeText(this, "Error en el càlcul", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Configurar botó C (Clear)
    private fun setupClearButton() {
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            tvResult?.text = "0"
            firstNumber = 0.0
            secondNumber = 0.0
            operation = null
            isNewInput = true
        }
    }
}