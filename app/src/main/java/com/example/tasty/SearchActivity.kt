package com.example.tasty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasty.model.Repo
import com.example.tasty.model.remote.api.SearchResponse
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.Result
import com.example.tasty.view.OnCardClicklistner
import com.example.tasty.view.adapters.DiscoverFragAdapter
import com.example.tasty.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_discover.*

class SearchActivity : AppCompatActivity() , OnCardClicklistner{


    lateinit var viewModel: MainViewModel
    lateinit var repo: Repo
    var list: MutableLiveData<SearchResponse> =MutableLiveData<SearchResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        
        etSearch.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               loadApiData(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }


    private fun setRecyclerView(list: ArrayList<Result>) {
        recyclerViewSearch.adapter = DiscoverFragAdapter(list, this)
        recyclerViewSearch.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }

    fun loadApiData(input: String) {
        viewModel.getSearchDetail(input).observe(this, Observer {
            val list = it as ArrayList<Result>              // we use here as to change type from list to arraylist
            setRecyclerView(list)
        })
        viewModel.getSearchDetail(input)
    }

    override fun onCardclicked(itemX: ItemX) {
        Toast.makeText(this@SearchActivity, "clicked", Toast.LENGTH_SHORT).show()
    }
}