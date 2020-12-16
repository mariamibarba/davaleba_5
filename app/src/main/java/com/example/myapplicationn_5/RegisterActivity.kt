package com.example.myapplicationn_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var registerButton: Button

    private lateinit var mAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mAuth= FirebaseAuth.getInstance()

        inputEmail = findViewById(R.id.signUpEmailEditText)
        inputPassword = findViewById(R.id.signUpPasswordEditText)
        registerButton = findViewById(R.id.signUpButton)

        registerButton.setOnClickListener {
            val email =inputEmail.text.toString()
            val password=inputPassword.text.toString()

            if(email.isEmpty()|| password.isEmpty()){
                Toast.makeText(this,"Empty!",Toast.LENGTH_LONG).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener { task->
                        if(task.isSuccessful){
                            startActivity(Intent(this,MainActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                        }

                    }

            }

        }
    }
}
