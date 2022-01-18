package com.anurag.lecture4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView : TextView = findViewById(R.id.text_View)

        if (intent.hasExtra("EnteredText") && intent.hasExtra("EnteredInteger")) {
            val name = "${
                intent.extras?.get("EnteredText").toString()
            }    ${intent.getIntExtra("EnteredInteger", 0)}"

//       val name = getIntent().getStringExtra("EnteredText")
            textView.text = name
        }

    }
}