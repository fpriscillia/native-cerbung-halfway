package com.example.projectuts_nmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectuts_nmp.databinding.ActivityReadingBinding
import com.example.projectuts_nmp.databinding.ActivityReadingRestrictedBinding
import com.squareup.picasso.Picasso

class ReadingRestrictedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadingRestrictedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadingRestrictedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //mengambil id cerbung yg terpilih
        val id = intent.getIntExtra(Global.STORY_ID, 1)

        //menampilkan recycler paragraf dengan adapter
        val lm: LinearLayoutManager = LinearLayoutManager(this)
        binding.recyclerReadingRestricted.layoutManager = lm
        binding.recyclerReadingRestricted.setHasFixedSize(true)
        binding.recyclerReadingRestricted.adapter = ParagraphAdapter(id)

        //menampilkan data-data sesuai id cerbung yg terpilih
        var url = Global.stories[id-1].url
        val builder = Picasso.Builder(this)
        builder.listener { picasso, uri, exception ->
            exception.printStackTrace() }
        builder.build().load(url).into(binding.imgCoverRes)
        binding.txtTitleRes.text = Global.stories[id-1].title
        binding.txtCreatorRes.text = "by " + Global.stories[id-1].creator
        binding.txtGenreRes.text = Global.stories[id-1].genre
        binding.txtAccess.text = Global.stories[id-1].access
    }
}