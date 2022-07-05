package com.garibyan.armen.tbc_task_7

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.garibyan.armen.tbc_task_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            if (!isEmptyField()) {
                addTextView()
                binding.edtText.setText("")
            }
        }

        binding.chackBox.setOnClickListener {
            when (binding.chackBox.isChecked) {
                true -> binding.edtText.inputType = InputType.TYPE_CLASS_NUMBER
                false -> binding.edtText.inputType = InputType.TYPE_CLASS_TEXT
            }
        }
    }

    private fun addTextView() {
        val textView = TextView(this)
        val input = binding.edtText.text.toString()

        when (binding.chackBox.isChecked) {
            true -> textView.text = getString(R.string.num) + input
            false -> textView.text = getString(R.string.txt) + input

        }

        binding.fieldsListLayout.visibility = View.VISIBLE
        textView.gravity = Gravity.CENTER
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25f)
        textView.setTextColor(Color.BLACK)
        binding.fieldsListLayout.addView(textView)
        binding.fieldsListLayout.addView(addLine())
    }

    private fun isEmptyField(): Boolean {
        return if (binding.edtText.text.toString().isEmpty()) {
            Toast.makeText(this, R.string.empty_field, Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(this, R.string.field_added, Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun addLine(): View {
        val line = View(this)
        val lineParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3)
        lineParams.setMargins(0, 5, 0, 5)
        line.layoutParams = lineParams
        line.setBackgroundColor(Color.BLACK)
        return line
    }
}