package com.tila.halloffame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tila.halloffame.data.Result
import com.tila.halloffame.repository.HeroesRepository

class HeroListViewModel : ViewModel() {
    private var _heroListLiveData : MutableLiveData<List<Result>> = MutableLiveData()
    val heroListLiveData : LiveData<List<Result>> get() = _heroListLiveData
    var progressBarVisibility : MutableLiveData<Boolean> = MutableLiveData(true)
    private val repository: HeroesRepository

    init {
        repository = HeroesRepository()
        getAllHeroes()
    }
    private fun getAllHeroes() =
        repository.getAllHeroes()?.characterData?.results?.let {
            _heroListLiveData.postValue(it)
            progressBarVisibility.postValue(false)
    }
}