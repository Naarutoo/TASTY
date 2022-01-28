package com.example.tasty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tasty.model.Repo
import com.example.tasty.model.remote.api.response.Result

class MainViewModel(val repo: Repo) : ViewModel() {

    fun getData(): LiveData<List<Result>> {
        return repo.getDataFromApi()
    }

}
class ViewModelFactory(private val repo: Repo):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo)as T
    }

}