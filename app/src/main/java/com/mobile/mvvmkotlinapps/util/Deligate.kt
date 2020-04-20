package com.mobile.mvvmkotlinapps.util

import kotlinx.coroutines.*


fun<T> lazyDefrred(block : suspend CoroutineScope.() -> T) : Lazy<Deferred<T>>{
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}