package com.example.myactivityforresult

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myactivityforresult.MainActivity.Companion.MESSAGE

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonBack = findViewById<Button>(R.id.btnBack)
        val text = findViewById<EditText>(R.id.result)

        buttonBack.setOnClickListener {
            val messageResult = text.text
            val intent = Intent()
            intent.putExtra(MESSAGE, messageResult.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}