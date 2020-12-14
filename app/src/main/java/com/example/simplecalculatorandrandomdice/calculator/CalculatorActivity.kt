package com.example.simplecalculatorandrandomdice.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.simplecalculatorandrandomdice.BaseActivity
import com.example.simplecalculatorandrandomdice.R
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Error
import java.lang.Exception

class CalculatorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        initListener()
    }

    override fun initListener() {
        // number listener
        btn0.setOnClickListener { appendOnClick(true, "0") }
        btn1.setOnClickListener { appendOnClick(true, "1") }
        btn2.setOnClickListener { appendOnClick(true, "2") }
        btn3.setOnClickListener { appendOnClick(true, "3") }
        btn4.setOnClickListener { appendOnClick(true, "4") }
        btn5.setOnClickListener { appendOnClick(true, "5") }
        btn6.setOnClickListener { appendOnClick(true, "6") }
        btn7.setOnClickListener { appendOnClick(true, "7") }
        btn8.setOnClickListener { appendOnClick(true, "8") }
        btn9.setOnClickListener { appendOnClick(true, "9") }
        btn_dot.setOnClickListener { appendOnClick(true, ".") }

        // operation lisetener
        btn_add.setOnClickListener { appendOnClick(false, "+") }
        btn_divide.setOnClickListener { appendOnClick(false, "/") }
        btn_minus.setOnClickListener { appendOnClick(false, "-") }
        btn_multiply.setOnClickListener { appendOnClick(false, "*") }
        btn_modulo.setOnClickListener { appendOnClick(false, "%") }
        btn_equal.setOnClickListener {
            calculate()
        }

        btn_delete.setOnClickListener {
            erase()
        }

        btn_clear.setOnClickListener {
            clear()
        }
    }

    fun appendOnClick(clear: Boolean, string: String) {
        if (tv_result.text.isNotEmpty()) {
            tv_input.text = ""
        }
            if (clear) {
                tv_result.text = ""
                tv_input.append(string)
            } else {
                tv_input.append(tv_result.text)
                tv_input.append(string)
                tv_result.text = ""
            }
    }

    fun clear() {
        tv_input.text = ""
        tv_result.text = ""
    }

    fun erase() {
        val inputText = tv_input.text
        if(inputText.isNotEmpty()) {
            tv_input.text = inputText.substring(0, inputText.length-1)
        }
        tv_result.text = ""
    }


    fun calculate() {
        try {
            val input = ExpressionBuilder(tv_input.text.toString()).build()
            val result = input.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tv_result.text = longResult.toString()
            } else tv_result.text = result.toString()
        } catch (e:Exception)  {
            Toast.makeText(this@CalculatorActivity,e.message,Toast.LENGTH_SHORT).show()
        }
    }
}