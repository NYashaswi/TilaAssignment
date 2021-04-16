package com.tila.halloffame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.tila.halloffame.R
import com.tila.halloffame.adapter.HeroListAdapter
import com.tila.halloffame.databinding.ActivityMainBinding
import com.tila.halloffame.viewmodel.HeroListViewModel

class HeroListActivity : AppCompatActivity() {
    lateinit var adapter : HeroListAdapter
    private val viewModel : HeroListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        init()
    }

    private fun init(){
        adapter = HeroListAdapter()
        binding.listHeroes.adapter = adapter
        observeAll()
    }

    private fun observeAll(){
       viewModel.heroListLiveData.observe(this, Observer {
           adapter.updateData(it)
       })
    }
}