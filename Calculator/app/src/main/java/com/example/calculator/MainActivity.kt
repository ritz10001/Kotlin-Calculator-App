package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var operationsInstance = Operations()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //CLEAR FUNCTION, CLEARS THE EVALUATION STRING COMPLETELY
        binding.cbutton.setOnClickListener {
            binding.tvResultView.text = ""
        }

        //ADDITION OPERATION
        binding.cbutton15.setOnClickListener {
            operationsInstance.addition()
        }

        //SUBTRACTION OPERATION
        binding.cbutton12.setOnClickListener {
            operationsInstance.subtraction()
        }

        //MULTIPLICATION OPERATION
        binding.cbutton8.setOnClickListener {
            operationsInstance.multiplication()
        }

        //DIVISION OPERATION
        binding.cbutton4.setOnClickListener {
            operationsInstance.division()
        }

        //NUMERICAL VALUES
        binding.cbutton13.setOnClickListener {


            binding.tvResultView.text = "1"
            operationsInstance.addValue(1)
        }

        binding.cbutton16.setOnClickListener {
            binding.tvResultView.text = "2"
            operationsInstance.addValue(2)
        }

        binding.cbutton14.setOnClickListener {
            binding.tvResultView.text = "3"
            operationsInstance.addValue(3)
        }

        binding.cbutton9.setOnClickListener {
            binding.tvResultView.text = "4"
            operationsInstance.addValue(4)
        }

        binding.cbutton10.setOnClickListener {
            binding.tvResultView.text = "5"
            operationsInstance.addValue(5)
        }

        binding.cbutton11.setOnClickListener {
            binding.tvResultView.text = "6"
            operationsInstance.addValue(6)
        }

        binding.cbutton5.setOnClickListener {
            binding.tvResultView.text = "7"
            operationsInstance.addValue(7)
        }

        binding.cbutton6.setOnClickListener {
            binding.tvResultView.text = "8"
            operationsInstance.addValue(8)
        }

        binding.cbutton7.setOnClickListener {
            binding.tvResultView.text = "9"
            operationsInstance.addValue(9)
        }

        //PERIOD OPERATOR
        binding.cbutton28.setOnClickListener {
            binding.tvResultView.text = "."
            operationsInstance.addPeriod()
        }

        //EQUALITY OPERATION
        binding.cbutton27.setOnClickListener {
            var result = operationsInstance.equals()
            Log.d("nothing", "From here $result")
            binding.tvResultView.text = result
        }
    }


}