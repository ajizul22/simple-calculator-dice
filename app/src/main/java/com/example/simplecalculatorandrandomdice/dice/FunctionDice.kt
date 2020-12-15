package com.example.simplecalculatorandrandomdice.dice

import android.widget.ImageView
import com.example.simplecalculatorandrandomdice.R

class FunctionDice(var ivDice: ImageView) {

    private fun rollDice() {
        val drawableResource = when((1..6).random()) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        ivDice.setImageResource(drawableResource)
    }

    fun getRollDice() {
        return rollDice()
    }

}