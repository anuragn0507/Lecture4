package com.anurag.lecture4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Explict intent and implicit intent
        // Explict intent: when you specify which activity is going to open after performing the certain action
        // implict intent : you don't specify exactly which activity is going to opent after performing the action means you know
        // you need to play the music but don't specify where you want to play it in google music or anywhere else

        val clickHere : Button = findViewById(R.id.click_here)
        val nameEditText : EditText = findViewById(R.id.name_edit_text)

        clickHere.setOnClickListener{
            val name = nameEditText.text
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("EnteredText", name)
            intent.putExtra("EnteredInteger", 100)
            startActivity(intent)
            finish()

        }

        val openurl : Button = findViewById(R.id.open_url)

        //Implicit intent
        openurl.setOnClickListener{
            val implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.multitasker.in"))

            startActivity(implicitIntent)

            //val iintent = Intent (Intent.ACTION_VIEW, Uri.parse("https://www.multitasker.in"))

        }

    }
}