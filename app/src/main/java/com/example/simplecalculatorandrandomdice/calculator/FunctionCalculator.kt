package com.example.simplecalculatorandrandomdice.calculator

import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class FunctionCalculator(var tvInput : TextView, var tvResult : TextView) {

    fun appendOnClick(clear: Boolean, string: String) {
        if (tvResult.text.isNotEmpty()) {
            tvInput.text = ""
        }
        if (clear) {
            tvResult.text = ""
            tvInput.append(string)
        } else {
            tvInput.append(tvResult.text)
            tvInput.append(string)
            tvResult.text = ""
        }
    }

    fun clear() {
        tvInput.text = ""
        tvResult.text = ""
    }

    fun erase() {
        val inputText = tvInput.text
        if(inputText.isNotEmpty()) {
            tvInput.text = inputText.substring(0, inputText.length-1)
        }
        tvResult.text = ""
    }

    private fun calculate() {
            val input = ExpressionBuilder(tvInput.text.toString()).build()
            val result = input.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else tvResult.text = result.toString()
    }

    fun getCalculate() {
        return calculate()
    }
}