package com.example.obser

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<View>(R.id.btn_add)
        val btnDelete = findViewById<View>(R.id.btn_delete)
        val btnDeleteAll = findViewById<View>(R.id.btn_delete_all)
        val btnSend = findViewById<View>(R.id.btn_send)

        val weather = Weather("天气APP")

        //创建两个用户
        val user1 = User("周三")
        val user2 = User("张飞")
        val user3 = User("李云龙")

        btnAdd.setOnClickListener {
            weather.addObserver(user1)
            weather.addObserver(user2)

            Toast.makeText(this, "当前有${weather.countObservers()}个订阅者", Toast.LENGTH_SHORT).show()
        }

        btnDelete.setOnClickListener {
            weather.deleteObserver(user2)
            weather.addObserver(user3)
        }

        btnDeleteAll.setOnClickListener {
            weather.deleteObservers()
        }

        btnSend.setOnClickListener {
            weather.sendMsg("下雨了")
        }
    }
}