package org.hyperskill.calculator.tip

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    val editText by lazy { findViewById<EditText>(R.id.edit_text) }
    val slider by lazy { findViewById<Slider>(R.id.slider) }
    val textView  by lazy { findViewById<TextView>(R.id.text_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.doOnTextChanged { text, start, before, count ->
            textView.text =
                if (text.isNullOrBlank()) ""
                else "Bill value: $text, tip percentage: ${slider.value.toInt()}%"
        }

        slider.addOnChangeListener { slider, value, fromUser ->
            textView.text =
                if (editText.text.isNullOrBlank()) ""
                else "Bill value: ${editText.text}, tip percentage: ${slider.value.toInt()}%"

        }
    }
}