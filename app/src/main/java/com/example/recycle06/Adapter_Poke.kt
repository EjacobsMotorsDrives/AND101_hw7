package com.example.recycle06

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter_Poke (private val pokeList1: List<String>,private val pokeList2: List<String>,private val pokeList3: List<String>) : RecyclerView.Adapter<Adapter_Poke.ViewHolder>() {



        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val pokeImage: ImageView
            val pokeForm: TextView
            val pokeAbil : TextView

            init {
                // Find our RecyclerView item's ImageView for future use
                pokeImage = view.findViewById(R.id.poke_image)
                pokeForm = view.findViewById(R.id.formText)
                pokeAbil = view.findViewById(R.id.abilityText)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.poke_item, parent, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            Glide.with(holder.itemView)
                .load(pokeList1[position])
                .centerCrop()
                .into(holder.pokeImage)

            holder.pokeForm.text = pokeList2[position]
            holder.pokeAbil.text = pokeList3[position]

        }

        override fun getItemCount() = pokeList1.size

    }





