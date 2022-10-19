package com.example.sharedstateflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class Repository {

    val randomNumber: Flow<Int> = flow {
        delay(5000)
        emit((0..99).random())
    }
}