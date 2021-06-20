package com.example.sigup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etemail:EditText
    lateinit var etpassword:EditText
    lateinit var btn1:Button
    lateinit var btn5:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        onClickListener()

    }
    fun castViews(){
        etemail=findViewById(R.id.etemail)
        etpassword=findViewById(R.id.etpassword)
        btn1=findViewById(R.id.btn1)
        btn5=findViewById(R.id.btn5)
    }
    fun onClickListener() {
        btn1.setOnClickListener {
            if (etemail.text.toString().isEmpty() || etpassword.text.toString().isEmpty()) {
                etemail.setError("you have to enter your email ")
                etpassword.setError("please enter a valid password")

            } else {
                Toast.makeText(baseContext, "Karibu to my Book app", Toast.LENGTH_LONG).show()
            }

            btn5.setOnClickListener {
                var intent = Intent(baseContext, signup::class.java)
                startActivity(intent)
            }
        }

    }
}