package com.example.myapplicationn_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var changePasswordEditText: EditText
    private lateinit var changePaswordButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)
        mAuth= FirebaseAuth.getInstance()
        changePaswordButton=findViewById(R.id.changePasswordButton)
        changePasswordEditText=findViewById(R.id.changePasswordEditText)

        changePaswordButton.setOnClickListener {
            val newPasword=changePasswordEditText.text.toString()
            if (newPasword.isEmpty()){
                Toast.makeText(this,"Empty",Toast.LENGTH_LONG).show()

            }else{
                mAuth.currentUser?.updatePassword(newPasword)?.addOnCompleteListener {
                    task->
                    if (task.isSuccessful){
                        startActivity(Intent(this,PersonActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}