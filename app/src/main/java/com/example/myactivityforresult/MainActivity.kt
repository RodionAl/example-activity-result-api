package com.example.myactivityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var tvResult: TextView? = null

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data

                intent?.getStringExtra(MESSAGE).let { str ->
                    tvResult?.let {
                        it.text = str
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNext = findViewById<Button>(R.id.btnNext)
        buttonNext.setOnClickListener {
            startForResult.launch(Intent(this, SecondActivity::class.java))
        }

        tvResult = findViewById(R.id.tvResult)
    }

    companion object {
        const val MESSAGE = "MESSAGE"
    }
}