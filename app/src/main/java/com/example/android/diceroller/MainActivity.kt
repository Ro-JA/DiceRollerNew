package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button);
        button.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it.
        val dice = Dice(6);
        val rollDice = dice.roll();
        val diceImage: ImageView = findViewById(R.id.image_view);
         when(rollDice) {
             1 -> diceImage.setImageResource(R.drawable.dice_1);
             2 -> diceImage.setImageResource(R.drawable.dice_2);
             3 -> diceImage.setImageResource(R.drawable.dice_3);
             4 -> diceImage.setImageResource(R.drawable.dice_4);
             5 -> diceImage.setImageResource(R.drawable.dice_5);
             6 -> diceImage.setImageResource(R.drawable.dice_6);
         }
    }
}

/**
 * Dice with a fixed number of sides.
 */

class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll() = (1..numSides).random();
}