package com.lohas.lohas.help.data.source

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.lohas.lohas.help.data.Splash
import com.lohas.lohas.help.splash.SplashDao

/**
 * this DataBase :
 * created by zaric on 2018-06-05 17:09
 */
@Database(entities = [(Splash::class)],version = 1)
abstract class AppDatabase :RoomDatabase() {

    abstract fun splashDao(): SplashDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "Tasks.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }

}