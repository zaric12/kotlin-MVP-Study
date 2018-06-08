package com.lohas.lohas.help

import android.content.Context
import com.lohas.lohas.control.AppExecutors
import com.lohas.lohas.help.data.Splash
import com.lohas.lohas.help.data.source.AppDatabase
import com.lohas.lohas.help.splash.SplashRepository
import com.lohas.lohas.help.splash.SplashTaskLocalDataSource
import com.lohas.lohas.help.splash.SplashTaskRemoteDataSource

/**
 * this Injection : 实现注入
 * created by zaric on 2018-06-07 11:47
 */
object Injection {
    fun provideSplashRepository(context: Context): SplashRepository<Splash> {
        val database = AppDatabase.getInstance(context)
        return SplashRepository.getInstance(SplashTaskRemoteDataSource.getInstance(AppExecutors()),
                SplashTaskLocalDataSource.getInstance(AppExecutors(), database.splashDao()))
    }
}