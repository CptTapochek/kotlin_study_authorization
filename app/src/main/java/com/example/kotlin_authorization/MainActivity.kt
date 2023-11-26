package com.example.kotlin_authorization
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPassword: EditText = findViewById(R.id.user_password)
        val button: Button = findViewById(R.id.button_reg)
        val linkToReg: TextView = findViewById(R.id.link_to_auth)

        linkToReg.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All field are required", Toast.LENGTH_LONG).show()
            } else {
                val user = User(login, email, password)
                val db = DbConnection(this, null)
                db.addUser(user)

                Toast.makeText(this, "User $login has been created", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
                //Hide keyboard
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0);
            }
        }
    }
}