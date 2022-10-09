package com.example.proxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.proxy.databinding.ActivityMainBinding
import com.example.proxy.utils.AppManager
import com.example.proxy.viewModel.ShowViewModel
import com.example.proxy.viewModel.impl.IShowViewModel

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding

    private var showViewModel: ShowViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //将Activity实例添加到AppManager的堆栈
        AppManager.getInstance().addActivity(this)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        if (showViewModel == null) {
            showViewModel = IShowViewModel(this, binding)
        }
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.tvWelcome.text = "你好，世界"
    }

    override fun onDestroy() {
        super.onDestroy()
        //将Activity实例从AppManager的堆栈中移除
        AppManager.getInstance().finishActivity(this)
    }
}