package com.example.projectuts_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projectuts_nmp.databinding.ActivityLoginBinding
import com.example.projectuts_nmp.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            var uname = binding.txtUsernameSignup.text.toString()
            var urlProfile = binding.txtProfileSignup.text.toString()
            var pwd1 = binding.txtPassword1.text.toString()
            var pwd2 = binding.txtPassword2.text.toString()
            if (uname != "" && urlProfile != "" && pwd1 != "" && pwd2 != "") {
                if (pwd1.equals(pwd2)) {
                    val intent = Intent(it.context,LoginActivity::class.java)
                    it.context.startActivity(intent)    
                }
                else {
                    Toast.makeText(this, "Password confirmation not valid", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Please fill all the input required", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnToLogin.setOnClickListener {
            val intent = Intent(it.context,LoginActivity::class.java)
            it.context.startActivity(intent)
        }
    }
}