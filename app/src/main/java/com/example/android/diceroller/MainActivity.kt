package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener { rollDice() }
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
//        Create new Dice object with 6 sides and roll it.
        val dice = Dice(6)
        val diceTwo = Dice(6)
        val rollDice = dice.roll()
        val rollDiceTwo = diceTwo.roll()

//        Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.image_view)
        val diceImageTwo: ImageView = findViewById(R.id.image_view_two)
//        Determine which drawable resource ID to use based on the dice roll(присваеваем пременой drawableResource картинку из ресурсов в зависимости от значения пременой rollDice)
        val drawableResource = when (rollDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResourceTwo = when (rollDiceTwo) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
//        Update the ImageView with the correct drawable resource ID(обновляем картинку кости согласно значения пердоваемое из when)
        diceImage.setImageResource(drawableResource)
        diceImageTwo.setImageResource(drawableResourceTwo)
//        Update the content description(добовляем описания картинки через метод contentDescription пердовая значения в виде строки для спецальных возможностей андройда)
        diceImage.contentDescription = rollDice.toString()
        diceImageTwo.contentDescription = rollDiceTwo.toString()
    }
}

/**
 * Dice with a fixed number of sides.
 */

class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll() = (1..numSides).random()
}