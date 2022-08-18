package com.dicoding.zoopediaapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAnimalAdapter(private val listAnimal: ArrayList<Animal>) : RecyclerView.Adapter<ListAnimalAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListAnimalAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_animal, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAnimalAdapter.ListViewHolder, position: Int) {
        val animal = listAnimal[position]

        Glide.with(holder.itemView.context)
            .load(animal.picture)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPicture)

        holder.tvName.text = animal.name
        holder.tvDescribe.text = animal.describe

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listAnimal[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int {
        return listAnimal.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescribe: TextView = itemView.findViewById(R.id.tv_item_describe)
        var imgPicture: ImageView = itemView.findViewById(R.id.img_item_picture)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Animal)
    }

}