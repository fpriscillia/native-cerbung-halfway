package com.example.projectuts_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projectuts_nmp.databinding.ActivityLoginBinding
import com.example.projectuts_nmp.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    val username = "BisaYuk"
    val password = "nmp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var unameInput = binding.txtUsernameLogin.text.toString()
            var pwdInput = binding.txtPasswordLogin.text.toString()
            if (unameInput != "" && pwdInput != "") {
                if(unameInput.equals(username) && pwdInput.equals(password)) {
                    val intent = Intent(it.context,MainActivity::class.java)
                    it.context.startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Username or password not valid", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Please fill all the input required", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnToSignUp.setOnClickListener {
            val intent = Intent(it.context,SignupActivity::class.java)
            it.context.startActivity(intent)
        }
    }
}