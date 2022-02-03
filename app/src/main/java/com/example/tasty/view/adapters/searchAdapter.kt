package com.example.tasty.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasty.R
import com.example.tasty.model.remote.api.ResultsItem

class searchAdapter(val searchList: ArrayList<ResultsItem>) : RecyclerView.Adapter<searchAdapter.searchHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): searchHolder {
        return searchHolder(LayoutInflater.from(parent.context).inflate(R.layout.search_item_view,parent,false))
    }

    override fun onBindViewHolder(holder: searchHolder, position: Int) {
        holder.setData(searchList[position])
    }

    override fun getItemCount(): Int {
        return searchList.size
    }


    class searchHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(resultsItem: ResultsItem) {


        }

    }
}