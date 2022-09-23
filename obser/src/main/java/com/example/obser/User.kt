
package com.example.obser

import android.util.Log

/**
 * 具体的订阅者\观察者
 */
class User(var name: String) : Observer {

    /**
     * 获取信息
     */
    override fun update(observable: Observable, data: Any) {
        Log.d("xuan", "${name}接收了信息---\"${data}\"")
    }

}