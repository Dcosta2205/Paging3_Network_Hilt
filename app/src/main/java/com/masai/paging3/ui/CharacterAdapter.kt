package com.masai.paging3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.paging3.R
import com.masai.paging3.model.CharacterDTO
import kotlinx.android.synthetic.main.item_layout.view.*

class CharacterAdapter :
    PagingDataAdapter<CharacterDTO, CharacterAdapter.CharacterViewHolder>(diffCallback = diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val resultsDTO = getItem(position)
        holder.setData(resultsDTO!!)
    }

    class CharacterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(resultsDTO: CharacterDTO) {
            view.apply {
                tv_name.text = resultsDTO.name
                Glide
                    .with(ivCharacter)
                    .load(resultsDTO.image)
                    .into(ivCharacter)

            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<CharacterDTO>() {
            override fun areItemsTheSame(oldItem: CharacterDTO, newItem: CharacterDTO) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CharacterDTO, newItem: CharacterDTO) =
                oldItem.equals(newItem)
        }
    }


}