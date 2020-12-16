package com.example.myapplicationn_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PersonActivity : AppCompatActivity() {

    private lateinit var personInforTextView: TextView
    private lateinit var changePasswordButton: Button
    private lateinit var logoutButton: Button

    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        mAuth= FirebaseAuth.getInstance()

        personInforTextView=findViewById(R.id.personInfoTextView)
        changePasswordButton=findViewById(R.id.passwordChangeButton)
        logoutButton=findViewById(R.id.logoutButton)

        personInforTextView.text=mAuth.currentUser?.uid
        logoutButton.setOnClickListener {
           startActivity(Intent(this,MainActivity::class.java))
           finish()
            mAuth.signOut()
        }
        changePasswordButton.setOnClickListener {
            startActivity(Intent(this,PasswordChangeActivity::class.java))
        }


    }
}