package com.example.kotlin_authorization

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPassword: EditText = findViewById(R.id.user_password_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All field are required", Toast.LENGTH_LONG).show()
            } else {
                val db = DbConnection(this, null)
                val isAuth = db.getUser(login, password)

                if(isAuth) {
                    Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()

                    //Hide keyboard
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                } else {
                    Toast.makeText(this, "Login or password is incorrect", Toast.LENGTH_LONG).show()
                }
            }
        }

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}