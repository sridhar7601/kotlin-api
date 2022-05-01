package com.example.myapplication

import android.media.Image
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.models.Property

class MyAdapter(private val data: List<Property>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(var view: View): RecyclerView.ViewHolder(view){

        fun bind(property: Property) {
//            val tv = view.findViewById<TextView>(R.id.list_tv)
//            tv.text = text
            val title = view.findViewById<TextView>(R.id.tvTitle)
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            val description = view.findViewById<TextView >(R.id.tvDescription)
            val button = view.findViewById<Button>(R.id.button)

            title.text=property.title
            description.text = property.description

            Glide.with(view.context).load(property.image).into(imageView)
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

      val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item ,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }
}