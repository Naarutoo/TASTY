package com.example.tasty.View.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.media.MediaBrowserServiceCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasty.R
import com.example.tasty.model.Repo
import com.example.tasty.model.local.DAO
import com.example.tasty.model.local.FoodDatabase
import com.example.tasty.model.remote.api.response.Result
import com.example.tasty.viewmodel.MainViewModel
import com.example.tasty.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_discover.*


class DiscoverFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var repo: Repo
    lateinit var dao: DAO
    lateinit var adapter1: FragmentAdapter1
    lateinit var manager : GridLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dao = FoodDatabase.getDatabase(requireContext()).getDao()
        repo = Repo(dao)
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(MainViewModel::class.java)

        viewModel.getData().observe(requireActivity(),Observer{
            val list = it as ArrayList<Result>
            setRecyclerView(list)
        })
    }

    private fun setRecyclerView(list: ArrayList<Result>) {
        recyclerview.apply {
            adapter1 = FragmentAdapter1(list)
            manager = GridLayoutManager(context,2)
        }

    }
}