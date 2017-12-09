package com.albertopita.holamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kotlin_android_extension.* //para evitarr el findviewById solamente mandamos llamar el puro botón con el ID :)
class kotlinAndroidExtensionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extension)

        val btn = findViewById<Button>(R.id.buttonById)

        btn.setOnClickListener{
            Toast.makeText(this,"Click By Id",Toast.LENGTH_LONG).show()
        }

        buttonByKAT.setOnClickListener{
            Toast.makeText(this,"Click By KAT!",Toast.LENGTH_LONG).show()
        }

    }
}
