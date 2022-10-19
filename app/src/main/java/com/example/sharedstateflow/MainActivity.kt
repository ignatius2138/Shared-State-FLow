package com.example.sharedstateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel by viewModels<MainActivityViewModel>()
        val textView1: TextView = findViewById(R.id.textView1)
        val textView2: TextView = findViewById(R.id.textView2)

        lifecycleScope.launch {
            viewModel.randomNumber.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect {
                textView1.text = it.toString()
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                delay(10000)
                viewModel.randomNumber.collect {
                    textView2.text = it.toString()
                }
            }
        }
    }
}