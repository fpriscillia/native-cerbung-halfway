package com.example.projectuts_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.projectuts_nmp.databinding.ActivityCreate1Binding
import com.example.projectuts_nmp.databinding.ActivityMainBinding

class Create1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCreate1Binding
    companion object {
        val STORYTITLE = "story_title"
        val STORYSINOPSIS = "story_sinopsis"
        val STORYCOVER = "story_cover"
        val STORYGENRE = "story_genre"
        val STORYACCESS = "story_access"
        val FIRSTPAR = "first_par"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreate1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //menampilkan daftar genre dalam spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Global.genre)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinGenre.adapter = adapter

        val savedTitle = intent.getStringExtra(Create2Activity.STORYTITLE).toString()
        val savedGenre = intent.getStringExtra(Create2Activity.STORYGENRE).toString()
        val savedSinopsis = intent.getStringExtra(Create2Activity.STORYSINOPSIS).toString()
        val savedCover = intent.getStringExtra(Create2Activity.STORYCOVER).toString()
        val savedAccess = intent.getStringExtra(Create2Activity.STORYACCESS).toString()
        val savedPar = intent.getStringExtra(Create2Activity.FIRSTPAR).toString()
        if (!savedTitle.equals(null)) {
            binding.txtCreateTitle.setText(savedTitle)
            binding.txtCreateCover.setText(savedCover)
            binding.txtCreateSinopsis.setText(savedSinopsis)
            binding.spinGenre.selectedItem.equals(savedGenre)
        }

        binding.btnCreateHome1.setOnClickListener {
            val intent = Intent(it.context,MainActivity::class.java)
            it.context.startActivity(intent)
        }

        binding.btnCreateProfile1.setOnClickListener {
            val intent = Intent(it.context,ProfileActivity::class.java)
            it.context.startActivity(intent)
        }

        binding.btnNext1.setOnClickListener {
            val intent = Intent(it.context,Create2Activity::class.java)
            intent.putExtra(STORYTITLE, binding.txtCreateTitle.text.toString())
            intent.putExtra(STORYGENRE, binding.spinGenre.selectedItem.toString())
            intent.putExtra(STORYSINOPSIS, binding.txtCreateSinopsis.text.toString())
            intent.putExtra(STORYCOVER, binding.txtCreateCover.text.toString())
            intent.putExtra(STORYACCESS, savedAccess)
            intent.putExtra(FIRSTPAR, savedPar)
            it.context.startActivity(intent)
        }
    }
}