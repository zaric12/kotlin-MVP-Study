package com.lohas.lohas.help.splash

import android.support.annotation.VisibleForTesting
import com.lohas.lohas.control.AppExecutors
import com.lohas.lohas.data.source.local.BaseDao
import com.lohas.lohas.data.source.remote.TaskRemoteDataSource
import com.lohas.lohas.help.data.Splash

/**
 * this SplashTaskRemoteDataSource :
 * created by zaric on 2018-06-07 15:14
 */
class SplashTaskRemoteDataSource  private constructor(splashExecutors:  AppExecutors):TaskRemoteDataSource<Splash>(splashExecutors){

    companion object {
        private var INSTANCE: SplashTaskRemoteDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors): SplashTaskRemoteDataSource {
            if (INSTANCE == null) {
                synchronized(SplashTaskRemoteDataSource::javaClass) {
                    INSTANCE = SplashTaskRemoteDataSource(appExecutors)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}