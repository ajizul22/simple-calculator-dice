package com.example.simplecalculatorandrandomdice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.simplecalculatorandrandomdice.calculator.CalculatorActivity
import com.example.simplecalculatorandrandomdice.dice.DiceActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toCalculator = findViewById<Button>(R.id.btn_to_calculator)
        val toDice: Button = findViewById(R.id.btn_to_dice)

        toDice.setOnClickListener {
            val intentToDice = Intent(this, DiceActivity::class.java)
            startActivity(intentToDice)
        }

        toCalculator.setOnClickListener {
            val intentCalculator = Intent(this, CalculatorActivity::class.java)
            startActivity(intentCalculator)
        }

    }
}