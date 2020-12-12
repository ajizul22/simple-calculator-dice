package com.example.simplecalculatorandrandomdice.dice

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.simplecalculatorandrandomdice.BaseActivity
import com.example.simplecalculatorandrandomdice.R
import kotlinx.android.synthetic.main.activity_dice.*
import java.util.*

class DiceActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        initListener()
    }

    override fun initListener() {
        dice.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val drawableResource = when(Random().nextInt(6) + 1) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        dice.setImageResource(drawableResource)
    }
}

