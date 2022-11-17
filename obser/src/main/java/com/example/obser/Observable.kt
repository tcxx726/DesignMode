package com.example.obser

import android.util.Log

/**
 * 发布者\被观察者
 */
open class Observable {

    /**
     * 订阅者\观察者个数
     */
    private var observers: MutableList<Observer> = ArrayList<Observer>()

    /**
     * 状态
     */
    private var changed = false


    /**
     * 添加订阅者\观察者
     */
    fun addObserver(observer: User?) {
//    fun addObserver(observer: Observer?) {
        if (observer == null) {
            throw NullPointerException("observer == null")
        }
        synchronized(this) {
            if (!observers.contains(observer)){
                Log.d("xuan", "------添加接收者：${observer.name}")
                observers.add(observer)
            }
        }
    }

    /**
     * 状态-->“无修改”
     */
    private fun clearChanged() {
        changed = false
    }

    /**
     * 获取订阅者\观察者个数
     */
    fun countObservers(): Int {
        return observers.size
    }

    /**
     * 删除订阅者\观察者
     */
    @kotlin.jvm.Synchronized
//    fun deleteObserver(observer: Observer) {
    fun deleteObserver(observer: User) {
        Log.d("xuan", "------删除接收者：${observer.name}")
        observers.remove(observer)
    }

    /**
     * 清空订阅者\观察者
     */
    @kotlin.jvm.Synchronized
    fun deleteObservers() {
        Log.d("xuan", "------删除所有接收者")
        observers.clear()
    }

    /**
     * 状态-->“修改”
     */
    private fun hasChanged(): Boolean {
        return changed
    }

    /**
     * 通知更新
     */
    @kotlin.jvm.JvmOverloads
    fun notifyObservers(data: Any? = null) {
        var arrays: Array<Observer?>? = null
        synchronized(this) {
            if (hasChanged()) {
                clearChanged()
                arrays = arrayOfNulls<Observer?>(observers.size)
                var i = 0
                observers.forEach {
                    arrays!![i++] = it
                }
            }
        }
        if (arrays != null) {
            for (observer in arrays!!) {
                data?.let { observer?.update(this, it) }
            }
        }
    }

    protected fun setChanged() {
        changed = true
    }
}