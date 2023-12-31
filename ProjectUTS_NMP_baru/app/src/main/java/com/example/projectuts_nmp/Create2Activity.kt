package com.example.projectuts_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.projectuts_nmp.databinding.ActivityCreate2Binding

class Create2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCreate2Binding
    companion object {
        var STORYTITLE = "story_title"
        var STORYSINOPSIS = "story_sinopsis"
        var STORYCOVER = "story_cover"
        var STORYGENRE = "story_genre"
        val STORYACCESS = "story_access"
        val FIRSTPAR = "first_par"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreate2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //mendapatkan data-data dari halaman create1
        var title = intent.getStringExtra(Create1Activity.STORYTITLE).toString()
        var genre = intent.getStringExtra(Create1Activity.STORYGENRE).toString()
        var sinopsis = intent.getStringExtra(Create1Activity.STORYSINOPSIS).toString()
        var cover = intent.getStringExtra(Create1Activity.STORYCOVER).toString()

        //data dari hlmn create3
        var savedTitle = intent.getStringExtra(Create3Activity.STORYTITLE).toString()
        val savedGenre = intent.getStringExtra(Create3Activity.STORYGENRE).toString()
        val savedSinopsis = intent.getStringExtra(Create3Activity.STORYSINOPSIS).toString()
        val savedCover = intent.getStringExtra(Create3Activity.STORYCOVER).toString()
        val savedAccess = intent.getStringExtra(Create3Activity.STORYACCESS).toString()
        val savedPar = intent.getStringExtra(Create3Activity.FIRSTPAR).toString()

        var access = ""
        binding.groupAccess.setOnCheckedChangeListener { radioGroup, i ->
            var selectedRadio = findViewById<RadioButton>(i)
            access = selectedRadio.text.toString()
        }

        if(!savedTitle.equals(null)) {
            binding.txtCreateFirstPar.setText(savedPar)
            if (binding.radioRestricted.text.equals(savedAccess)) {
                binding.radioRestricted.isChecked = true
            }
            else if(binding.radioPublic.text.equals(savedAccess)) {
                binding.radioPublic.isChecked = true
            }
        }

        binding.btnPrev2.setOnClickListener {
            val intent = Intent(it.context,Create1Activity::class.java)
            intent.putExtra(STORYTITLE, title)
            intent.putExtra(STORYGENRE, genre)
            intent.putExtra(STORYSINOPSIS, sinopsis)
            intent.putExtra(STORYCOVER, cover)
            intent.putExtra(STORYACCESS, access)
            intent.putExtra(FIRSTPAR, binding.txtCreateFirstPar.text.toString())

            it.context.startActivity(intent)
        }

        binding.btnNext2.setOnClickListener {
            val intent = Intent(it.context,Create3Activity::class.java)
            intent.putExtra(STORYTITLE, title)
            intent.putExtra(STORYGENRE, genre)
            intent.putExtra(STORYSINOPSIS, sinopsis)
            intent.putExtra(STORYCOVER, cover)
            intent.putExtra(STORYACCESS, access)
            intent.putExtra(FIRSTPAR, binding.txtCreateFirstPar.text.toString())

            it.context.startActivity(intent)
        }

        binding.btnCreate2Home.setOnClickListener {
            val intent = Intent(it.context,MainActivity::class.java)
            it.context.startActivity(intent)
        }

        binding.btnCreate2Profile.setOnClickListener {
            val intent = Intent(it.context,ProfileActivity::class.java)
            it.context.startActivity(intent)
        }
    }
}