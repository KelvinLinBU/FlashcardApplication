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
    var score = 0 // Declare score as a class-level variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcards)

        val generate = findViewById<Button>(R.id.generate_button)
        generate.setOnClickListener {
            var nums = 0
            while (nums < 10) {
                val generatedScore = generate_problem()
                score += generatedScore // Update the score
                Toast.makeText(this, "Reaches 2", Toast.LENGTH_SHORT).show()
                nums += 1
            }
            Toast.makeText(this, "Score: $score", Toast.LENGTH_LONG).show() // Show the total score
        }
    }

    fun generate_problem(): Int {
        var score = 0 // Declare a local score variable for this problem
        val solution_input = findViewById<EditText>(R.id.solution_input)
        val submit = findViewById<Button>(R.id.submitsolution_button)
        var top_operand = 0
        var bottom_operand = 0
        var operation = 0
        top_operand = (1..99).random()
        findViewById<TextView>(R.id.top_operand).text = top_operand.toString()
        bottom_operand = (1..20).random()
        findViewById<TextView>(R.id.bottom_operand).text = bottom_operand.toString()
        operation = (1..2).random()
        Toast.makeText(this, "reaches", Toast.LENGTH_LONG).show()
        if (operation == 1) {
            findViewById<TextView>(R.id.operation).text = "+"
        } else {
            findViewById<TextView>(R.id.operation).text = "-"
        }
        submit.setOnClickListener {
            val guess = solution_input.text.toString().toInt()
            if (operation == 1) {
                if ((top_operand + bottom_operand) == guess) {
                    score += 1 // Update the score for this problem
                }
            } else {
                if ((top_operand - bottom_operand) == guess) {
                    score += 1 // Update the score for this problem
                }
            }
            // You don't need return@setOnClickListener here
        }
        return score // Return the score for this problem
    }
}



