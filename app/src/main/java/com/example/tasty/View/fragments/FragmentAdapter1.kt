package com.example.tasty.View.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tasty.R
import com.example.tasty.model.remote.api.response.Result
import kotlinx.android.synthetic.main.fooditem_view.view.*

class FragmentAdapter1(val foodlist:ArrayList<Result>): RecyclerView.Adapter<FragmentAdapter1.Foodholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Foodholder {
        return Foodholder(LayoutInflater.from(parent.context).inflate(R.layout.fooditem_view,parent,false))
    }

    override fun onBindViewHolder(holder: Foodholder, position: Int) {
        holder.setData(foodlist[position])
    }

    override fun getItemCount(): Int {
        return foodlist.size
    }

    
    class Foodholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      fun setData(result: Result){
          itemView.apply {
              Glide.with(food_image).load(result.item.thumbnail_url).into(food_image)
              food_name.text = result.item.name
          }
      }
    }
}