package com.example.projectuts_nmp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_nmp.databinding.ParagraphItemBinding

class ParagraphAdapter(val id:Int) : RecyclerView.Adapter<ParagraphAdapter.ParagraphViewHolder>() {
    class ParagraphViewHolder(val binding:
                          ParagraphItemBinding
    ):RecyclerView.ViewHolder(binding.root)

    //untuk mendapatkan paragraf sesuai id cerbung
    val paragraph = Global.selecting(id)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParagraphAdapter.ParagraphViewHolder {
        val binding = ParagraphItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ParagraphViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParagraphAdapter.ParagraphViewHolder, position: Int) {
        with(holder.binding) {
            txtParagraph.text = paragraph[position].contentCerbung
            txtWritter.text = "by " + paragraph[position].username
        }
    }

    override fun getItemCount(): Int {
        return paragraph.size
    }
}