package com.example.sharedstateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn

class MainActivityViewModel : ViewModel() {
    private val repository : Repository = Repository()
    val randomNumber: StateFlow<Int> = repository.randomNumber.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        0
    )
}