package com.example.tasty.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasty.model.local.DAO
import com.example.tasty.model.remote.Network
import com.example.tasty.model.remote.api.ApiService
import com.example.tasty.model.remote.api.ResultsItem
import com.example.tasty.model.remote.api.SearchResponse
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.ResponseDTO
import com.example.tasty.model.remote.api.response.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class Repo() {
    val liveData = MutableLiveData<List<Result>>()
    fun getDataFromApi(): LiveData<List<Result>> {       // liveData vs mutableLiveData!! why we have not used livedata here
        CoroutineScope(IO).launch {
            try {                                              // try is for scenerio if internet is not available it doesn't crash
                val list = Network.api.getData().results
                liveData.postValue(list)
            } catch (e: Exception) {
            }
        }
        return liveData
    }

    val liveData2 = MutableLiveData<ItemX>()
    fun getDetailFromApi(int: Int): MutableLiveData<ItemX> {
        CoroutineScope(IO).launch {
            liveData2.postValue(Network.api.getDetail(int))

        }
        return liveData2
    }

    val liveData3 = MutableLiveData<SearchResponse>()
    fun getSearchDataFromApi(string: String): MutableLiveData<SearchResponse> {
        CoroutineScope(IO).launch {
            liveData3.postValue(Network.api.getSearchview(string))
        }
        return liveData3
    }

}
