package com.example.obser

import android.util.Log

/**
 * 具体的发布者\被观察者
 */
class Weather(var name: String) : Observable() {

    /**
     * 发布信息
     */
    fun sendMsg (state :String){
        Log.d("xuan", "\n")
        Log.d("xuan", "----------${name}发布了一条天气信息--------")
        setChanged()
        notifyObservers(state)
    }
}