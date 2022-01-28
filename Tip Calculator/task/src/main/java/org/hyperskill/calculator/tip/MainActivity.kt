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
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    val editText by lazy { findViewById<EditText>(R.id.edit_text) }
    val slider by lazy { findViewById<Slider>(R.id.slider) }
    val textView  by lazy { findViewById<TextView>(R.id.text_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.doOnTextChanged { text, start, before, count ->
            setTextView()
        }

        slider.addOnChangeListener { slider, value, fromUser ->
            setTextView()
        }
    }

    fun setTextView() {
        textView.text =
            if (editText.text.isNullOrBlank()) ""
            else {
                val tip = editText.text.toString().toDouble() * slider.value.toInt() / 100
                val xd = BigDecimal(tip).setScale(2, RoundingMode.HALF_EVEN)
                "Tip amount: $xd"
            }

    }
}