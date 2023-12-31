package com.example.projectuts_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projectuts_nmp.databinding.ActivityCreate3Binding

class Create3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCreate3Binding
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
        binding = ActivityCreate3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //mengambil data-data dari halaman create2
        val title = intent.getStringExtra(Create2Activity.STORYTITLE).toString()
        val genre = intent.getStringExtra(Create2Activity.STORYGENRE).toString()
        val sinopsis = intent.getStringExtra(Create2Activity.STORYSINOPSIS).toString()
        val paragraph = intent.getStringExtra(Create2Activity.FIRSTPAR).toString()
        val access = intent.getStringExtra(Create2Activity.STORYACCESS).toString()
        val cover = intent.getStringExtra(Create2Activity.STORYCOVER).toString()

        binding.txtPreviewTitle.text = title
        binding.txtPreviewGenre.text = genre
        binding.txtPreviewSinopsis.text = sinopsis
        binding.txtPreviewFirst.text = paragraph
        binding.txtPreviewAccess.text = access

        binding.btnPrev3.setOnClickListener {
            val intent = Intent(it.context,Create2Activity::class.java)
            intent.putExtra(STORYTITLE, title)
            intent.putExtra(STORYGENRE, genre)
            intent.putExtra(STORYSINOPSIS, sinopsis)
            intent.putExtra(STORYCOVER, cover)
            intent.putExtra(STORYACCESS, access)
            intent.putExtra(FIRSTPAR, paragraph)

            it.context.startActivity(intent)
        }

        binding.btnPublish.setOnClickListener {
            if (binding.checkAgree.isChecked) {
                var storyid = Global.stories.size + 1
                //menambah data cerbung baru ke dalam array stories dan paragraphs
                Global.stories.add(Story(storyid, title, "BisaYuk", genre, access, sinopsis, cover))
                Global.paragraphs.add(Paragraph(storyid,"BisaYuk", paragraph))

                Toast.makeText(this,  "Cerbung Saved Successfully", Toast.LENGTH_SHORT).show()
                //mengarah ke main activity
                val intent = Intent(it.context,MainActivity::class.java)
                it.context.startActivity(intent)
            }
            else {
                Toast.makeText(this,  "Please check the rules aggrement", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnCreate3Home.setOnClickListener {
            val intent = Intent(it.context,MainActivity::class.java)
            it.context.startActivity(intent)
        }

        binding.btnCreate3Profile.setOnClickListener {
            val intent = Intent(it.context,ProfileActivity::class.java)
            it.context.startActivity(intent)
        }
    }
}