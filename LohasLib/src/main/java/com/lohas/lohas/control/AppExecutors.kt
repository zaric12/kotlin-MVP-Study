package com.lohas.lohas.control

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * 线程池数量
 */
const val THREAD_COUNT = 3
/**
 * this AppExecutors : 任务执行器-线程池  任务分组、线程控制
 * created by zaric on 2018-06-07 10:19
 */
open class AppExecutors constructor(
        val diskIO: Executor = DiskIOThreadExecutor(),
        val networkIO: Executor = Executors.newFixedThreadPool(THREAD_COUNT),
        val mainThread: Executor = MainThreadExecutor()
) {

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}