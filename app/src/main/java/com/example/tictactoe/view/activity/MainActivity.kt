package com.example.tictactoe.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tictactoe.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProviders
import com.example.tictactoe.R
import com.example.tictactoe.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    // Obtain ViewModel from ViewModelProviders
    private val mainViewModel: MainViewModel by lazy { ViewModelProviders.of(this).get(
        MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.viewModel = mainViewModel //let View know viewModel
        binding.lifecycleOwner = this // let View observe change
    }
}
