package com.example.proxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proxy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAa.text = "你好，世界"
    }
}