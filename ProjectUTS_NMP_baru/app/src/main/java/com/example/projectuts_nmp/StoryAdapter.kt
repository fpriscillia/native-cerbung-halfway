package com.example.projectuts_nmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_nmp.databinding.StoryItemBinding
import com.squareup.picasso.Picasso

class StoryAdapter() : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {
    class StoryViewHolder(val binding:
                          StoryItemBinding
    ):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = StoryItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return StoryViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return Global.stories.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val url = Global.stories[position].url
        with(holder.binding) {
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener { picasso, uri, exception -> exception.printStackTrace() }
            Picasso.get().load(url).into(imgCardCover)
            txtCardTitle.text = Global.stories[position].title
            txtCardCreator.text = "by " + Global.stories[position].creator
            txtCardSinopsis.text = Global.stories[position].sinopsis

            btnCardRead.setOnClickListener {
                val story = Global.stories[position]

                if (story.access == "Public") {
                    val intent = Intent(it.context, ReadingActivity::class.java)
                    intent.putExtra(Global.STORY_ID, Global.stories[position].id)
                    it.context.startActivity(intent)
                } else {
                    val intent = Intent(it.context, ReadingRestrictedActivity::class.java)
                    intent.putExtra(Global.STORY_ID, Global.stories[position].id)
                    it.context.startActivity(intent)
                }
            }

        }
    }
}