package com.example.sigup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class signup : AppCompatActivity() {
    lateinit var etname: EditText
    lateinit var spgender: Spinner
    lateinit var etemail1: EditText
    lateinit var etphone1: EditText
    lateinit var etpswd: EditText
    lateinit var btn2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        castViews()
        onClick()
    }

    fun castViews() {
        etname = findViewById(R.id.etname)
        spgender = findViewById(R.id.spgender)
        etemail1 = findViewById(R.id.etemail1)
        etphone1 = findViewById(R.id.etphone1)
        etpswd = findViewById(R.id.etpswd)
        btn2 = findViewById(R.id.btn2)
        val gender = arrayOf("male", "female", "non-binary", "prefer not to say")
        val genderAdapter =
            ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, gender)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spgender.adapter = genderAdapter
    }

    fun onClick() {
        btn2.setOnClickListener {
            var intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)


            if (etname.text.toString().isEmpty() || etemail1.text.toString().isEmpty() ||
                etphone1.text.toString().isEmpty() || etpswd.text.toString().isEmpty()
            ) {
                etname.setError("you must enter your name")
                etemail1.setError("please enter a valid email address")
                etphone1.setError("please enter your phone number")
                etpswd.setError("Please enter a valid password")
            } else {
                val user =User(name = etname.text.toString(),gender = "",email = etemail1.text.toString()
                    ,phoneNumber = etphone1.text.toString(),password = etpswd.text.toString())
                Toast.makeText(baseContext,user.toString(),Toast.LENGTH_LONG).show()


            }
        }
    }
    data class User(
        var name:String,
        var gender:String,
        var email:String,
        var phoneNumber:String,
        var password:String
    )

}