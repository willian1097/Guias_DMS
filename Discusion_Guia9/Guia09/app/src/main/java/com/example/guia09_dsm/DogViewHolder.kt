package com.example.guia09_dsm

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.guia09_dsm.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

    class DogViewHolder(view: View?) : RecyclerView.ViewHolder(view!!){
        private val itemDogBinding: ItemDogBinding

        init {
            itemDogBinding = ItemDogBinding.bind(view!!)
        }

        fun bind(imageUrl: String?) {
            Picasso.get().load(imageUrl).into(itemDogBinding.ivDog)
        }
    }
