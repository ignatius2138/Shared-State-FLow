package com.example.sharedstateflow

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val repository : Repository = Repository()

    val randomNumber = repository.randomNumber

}