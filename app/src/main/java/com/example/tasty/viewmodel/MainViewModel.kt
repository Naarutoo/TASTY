package com.example.tasty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tasty.model.Repo
import com.example.tasty.model.remote.api.SearchResponse
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.Result

class MainViewModel(val repo: Repo) : ViewModel() {

    fun getData(): LiveData<List<Result>> {
        return repo.getDataFromApi()
    }

    fun getDetail(int:Int): MutableLiveData<ItemX> {
        return repo.getDetailFromApi(int)
    }

    fun getSearchDetail(string: String):MutableLiveData<SearchResponse>{
        return repo.getSearchDataFromApi(string)
    }

}

class ViewModelFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }

}