package com.example.flashcardapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flashcardapplication.ui.theme.FlashcardApplicationTheme
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Flashcards : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcards)
        val solution_input = findViewById<EditText>(R.id.solution_input)
        val submit = findViewById<Button>(R.id.submitsolution_button)
        val generate = findViewById<Button>(R.id.generate_button)

        generate.setOnClickListener {
            var score = 0
            var nums = 0
            var top_operand = generate_top()
            var bottom_operand = generate_bottom()
            var operation = generate_operation()
            findViewById<TextView>(R.id.top_operand).text = top_operand.toString()
            findViewById<TextView>(R.id.bottom_operand).text = bottom_operand.toString()
            submit.setOnClickListener {
                if(nums > 10){
                    Toast.makeText(this, "Game Over! Your Score Is: $score", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val guess = solution_input.text.toString().toInt()
                if (operation == 1) {
                    if ((top_operand + bottom_operand) == guess) {
                        score += 1
                    }
                } else {
                    if ((top_operand - bottom_operand) == guess) {
                        score += 1
                    }
                }

                top_operand = generate_top()
                bottom_operand = generate_bottom()
                operation = generate_operation()
                findViewById<TextView>(R.id.top_operand).text = top_operand.toString()
                findViewById<TextView>(R.id.bottom_operand).text = bottom_operand.toString()
                if (operation == 1) {
                    findViewById<TextView>(R.id.operation).text = "+"
                } else {
                    findViewById<TextView>(R.id.operation).text = "-"
                }
                nums += 1


            }

            return@setOnClickListener
        }
    }

    fun generate_top(): Int {
        var vals = (1..99).random()
        return vals
    }

    fun generate_bottom(): Int {
        var vals = (1..20).random()
        return vals
    }

    fun generate_operation(): Int {
        var vals = (1..2).random()
        return vals
    }
}
