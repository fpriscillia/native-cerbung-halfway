package com.example.projectuts_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectuts_nmp.databinding.ActivityLoginBinding
import com.example.projectuts_nmp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProfileHome.setOnClickListener {
            val intent = Intent(it.context,MainActivity::class.java)
            it.context.startActivity(intent)
        }

        binding.btnProfilCreate.setOnClickListener {
            val intent = Intent(it.context,Create1Activity::class.java)
            it.context.startActivity(intent)
        }
    }
}