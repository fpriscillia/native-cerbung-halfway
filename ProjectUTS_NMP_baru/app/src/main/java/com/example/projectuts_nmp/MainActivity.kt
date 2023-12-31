package com.example.projectuts_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectuts_nmp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onBackPressed() {
        Toast.makeText(this, "Can not logout from this page", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lm: LinearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = lm
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = StoryAdapter()

        binding.btnMainCreate.setOnClickListener {
            val intent = Intent(it.context,Create1Activity::class.java)
            it.context.startActivity(intent)
        }

        binding.btnMainProfile.setOnClickListener {
            val intent = Intent(it.context,ProfileActivity::class.java)
            it.context.startActivity(intent)
        }
    }
}