package com.anurag.lecture4

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class CaptureImageActivity : AppCompatActivity() {
    private var imageView: ImageView? = null

    companion object {
        const val CAPTURE_IMAGE_REQUEST_CODE = 1111
        const val CAMERA_REQUEST = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture_image)

        imageView = findViewById(R.id.imageView)

        val captureImageButtton: Button = findViewById(R.id.captured_button)

        //Ask for runtime permission
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA), CAMERA_REQUEST)
        }

        captureImageButtton.setOnClickListener {
            val cameraintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraintent, CAPTURE_IMAGE_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode ==CAPTURE_IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            // GET THE IMAGE
            val photo: Bitmap = intentData?.extras?.get("data") as Bitmap
            imageView?. setImageBitmap(photo)
         }
     }
}