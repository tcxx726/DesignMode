package com.example.proxy

import android.os.Bundle
import android.util.Log
import android.util.Range
import androidx.appcompat.app.AppCompatActivity
import com.example.proxy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // 杀杀杀
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = Range(1,2)
        Log.d("xuan", "onCreate: $i")

    }
}