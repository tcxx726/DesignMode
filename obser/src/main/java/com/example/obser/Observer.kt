package com.example.obser


/**
 * 订阅者\观察者接口
 */
interface Observer {
    fun update(observable: Observable, data:Any)
}