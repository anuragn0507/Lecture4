package com.anurag.lecture4

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class CaptureImageActivity : AppCompatActivity() {
    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture_image)

        imageView = findViewById(R.id.imageView )

        val captureImageButtton: Button = findViewById(R.id.captured_button)

        //Ask for runtime permission
        if (ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 1000)



    }
}