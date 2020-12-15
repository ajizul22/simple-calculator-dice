package com.example.simplecalculatorandrandomdice.dice

import android.os.Bundle
import com.example.simplecalculatorandrandomdice.BaseActivity
import com.example.simplecalculatorandrandomdice.R
import kotlinx.android.synthetic.main.activity_dice.*
import java.util.*

class DiceActivity: BaseActivity() {

    lateinit var function: FunctionDice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        function = FunctionDice(iv_dice)
        initListener()
    }

    override fun initListener() {
        iv_dice.setOnClickListener {
            function.getRollDice()
        }
    }
}
