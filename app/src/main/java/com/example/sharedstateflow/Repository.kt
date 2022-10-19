package com.example.sharedstateflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.random.nextInt

class Repository {

    val randomNumber: Flow<Int> = flow {
        delay(5000)
        emit(Random.nextInt(0..99))
    }
}