package com.example.projectuts_nmp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectuts_nmp.databinding.ActivityReadingBinding
import com.squareup.picasso.Picasso


class ReadingActivity : AppCompatActivity() {
    private lateinit var binding:ActivityReadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //mengambil id cerbung yg terpilih
        val id = intent.getIntExtra(Global.STORY_ID, 1)

        //menampilkan recycler paragraf dengan adapter
        val lm: LinearLayoutManager = LinearLayoutManager(this)
        binding.recyclerReading.layoutManager = lm
        binding.recyclerReading.setHasFixedSize(true)
        binding.recyclerReading.adapter = ParagraphAdapter(id)

        //menampilkan data-data sesuai id cerbung yg terpilih
        var url = Global.stories[id-1].url
        val builder = Picasso.Builder(this)
        builder.listener { picasso, uri, exception ->
            exception.printStackTrace() }
        builder.build().load(url).into(binding.imgCover)
        binding.txtTitle.text = Global.stories[id-1].title
        binding.txtCreator.text = "by " + Global.stories[id-1].creator
        binding.txtGenre.text = Global.stories[id-1].genre

        binding.btnSubmit.setOnClickListener {
            var paragraph = binding.txtNewParagraph.text.toString()
            if (paragraph != "") {
                //menambahkan paragraf baru ke array paragraphs
                Global.paragraphs.add(Paragraph(id, "BisaYuk", paragraph))
                Toast.makeText(this,  "New paragraph Added Successfully", Toast.LENGTH_SHORT).show()

                //refresh halaman activity ini
                val intent = intent
                overridePendingTransition(0, 0)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                finish()
                overridePendingTransition(0, 0)
                startActivity(intent)
            }
            else {
                Toast.makeText(this,  "Please fill your new paragraph first", Toast.LENGTH_SHORT).show()
            }
        }
    }
}