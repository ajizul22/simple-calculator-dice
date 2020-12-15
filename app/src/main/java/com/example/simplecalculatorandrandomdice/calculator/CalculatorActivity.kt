package com.example.simplecalculatorandrandomdice.calculator

import android.os.Bundle
import android.widget.Toast
import com.example.simplecalculatorandrandomdice.BaseActivity
import com.example.simplecalculatorandrandomdice.R
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorActivity : BaseActivity() {

    lateinit var function: FunctionCalculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        function = FunctionCalculator(tv_input, tv_result)
        initListener()
    }

    override fun initListener() {
        btn0.setOnClickListener { function.appendOnClick(true, "0") }
        btn1.setOnClickListener { function.appendOnClick(true, "1") }
        btn2.setOnClickListener { function.appendOnClick(true, "2") }
        btn3.setOnClickListener { function.appendOnClick(true, "3") }
        btn4.setOnClickListener { function.appendOnClick(true, "4") }
        btn5.setOnClickListener { function.appendOnClick(true, "5") }
        btn6.setOnClickListener { function.appendOnClick(true, "6") }
        btn7.setOnClickListener { function.appendOnClick(true, "7") }
        btn8.setOnClickListener { function.appendOnClick(true, "8") }
        btn9.setOnClickListener { function.appendOnClick(true, "9") }

        btn_dot.setOnClickListener { function.appendOnClick(true, ".") }
        btn_add.setOnClickListener { function.appendOnClick(false, "+") }
        btn_divide.setOnClickListener { function.appendOnClick(false, "/") }
        btn_minus.setOnClickListener { function.appendOnClick(false, "-") }
        btn_multiply.setOnClickListener { function.appendOnClick(false, "*") }
        btn_modulo.setOnClickListener { function.appendOnClick(false, "%") }

        btn_equal.setOnClickListener {
            function.getCalculate()
        }

        btn_delete.setOnClickListener {
            function.erase()
        }

        btn_clear.setOnClickListener {
            function.clear()
        }
    }
}