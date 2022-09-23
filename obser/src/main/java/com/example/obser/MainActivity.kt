package com.example.obser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.obser.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weather = Weather("天气APP")

        //创建两个用户
        val user1 = User("周三")
        val user2 = User("张飞")
        val user3 = User("李云龙")

        weather.addObserver(user1)
        weather.addObserver(user2)

        weather.countObservers()

        weather.sendMsg("下雨了")

        weather.deleteObserver(user2)

        weather.sendMsg("天晴了")

        weather.addObserver(user3)

        weather.sendMsg("下雪了")

        weather.deleteObservers()

        weather.sendMsg("打雷了")

    }
}