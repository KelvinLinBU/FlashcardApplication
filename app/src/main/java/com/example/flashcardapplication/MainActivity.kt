package com.example.flashcardapplication

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

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val submit_button = findViewById<Button>(R.id.submit_button)
        val login_field  = findViewById<EditText>(R.id.login)
        val password_field = findViewById<EditText>(R.id.password)
        submit_button.setOnClickListener{
            var login_input = login_field.text.toString()
            var password_input = password_field.text.toString()
            if ((login_input != "Usernamez")||(password_input != "Password3")) {
               var incorrect_toast = Toast.makeText(this,"Your Username/Password is Wrong!", Toast.LENGTH_SHORT)
                incorrect_toast.show()
            }
            else{
                var correct_toast = Toast.makeText(this,"Login Successful!" , Toast.LENGTH_SHORT)
                correct_toast.show()
            }
            }

        }


    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlashcardApplicationTheme {
        Greeting("Android")
    }
}