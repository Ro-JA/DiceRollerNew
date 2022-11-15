package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button);
        button.setOnClickListener {
            rollDice()

        }
    }

    private fun rollDice() {
        val dice = Dice(6);
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView);
        resultTextView.text = diceRoll.toString();
    }
}

class Dice(private val numSides: Int) {
    fun roll() = (1..numSides).random();
}