package com.example.tasty.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasty.model.local.DAO
import com.example.tasty.model.remote.Network
import com.example.tasty.model.remote.api.ApiService
import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.ResponseDTO
import com.example.tasty.model.remote.api.response.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class Repo(val dao: DAO) {

    fun getDataFromApi(): LiveData<List<Result>> {
        CoroutineScope(IO).launch {
            try {
                val list = Network.api.getData().results
                if (list != null) {
                    dao.deleteData()
                }
                list?.forEach {
                    dao.insertData(it!!)
                }

            } catch (e: Exception) {


            }
        }
        return dao.getData()
    }
}