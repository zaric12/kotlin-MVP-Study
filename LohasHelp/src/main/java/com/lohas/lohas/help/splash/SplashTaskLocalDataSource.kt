package com.lohas.lohas.help.splash

import android.support.annotation.VisibleForTesting
import com.lohas.lohas.control.AppExecutors
import com.lohas.lohas.data.source.local.BaseDao
import com.lohas.lohas.data.source.local.TaskLocalDataSource
import com.lohas.lohas.help.data.Splash

/**
 * this SplashTaskLocalDataSource :
 * created by zaric on 2018-06-07 15:13
 */
class SplashTaskLocalDataSource private constructor(splashExecutors:  AppExecutors,splashdao : BaseDao<Splash>) :TaskLocalDataSource<Splash>(splashExecutors,splashdao){

    companion object {
        private var INSTANCE: SplashTaskLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, splashDao: SplashDao): SplashTaskLocalDataSource {
            if (INSTANCE == null) {
                synchronized(SplashTaskLocalDataSource::javaClass) {
                    INSTANCE = SplashTaskLocalDataSource(appExecutors, splashDao)
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