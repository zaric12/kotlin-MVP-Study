package com.lohas.lohas.help.splash

import com.lohas.lohas.data.source.BaseDataSource
import com.lohas.lohas.data.source.BaseRepository
import com.lohas.lohas.help.data.Splash

/**
 * this SplashRepository : 启动页的数据仓库
 * created by zaric on 2018-06-05 11:24
 * @param remoteDataSource 远程数据
 * @param localDataSource 本地数据
 */
class SplashRepository<Splash>(val splashRemoteDataSource:BaseDataSource<Splash>, val splashLocalDataSource: BaseDataSource<Splash>): BaseRepository<Splash>(splashRemoteDataSource,splashLocalDataSource) {

    override fun cacheAndPerform(data: Splash, perform: (Splash) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    companion object {

        private var INSTANCE: SplashRepository<Splash>? = null

        /**
         * Returns the single instance of this class, creating it if necessary.

         * @param tasksRemoteDataSource the backend data source
         * *
         * @param tasksLocalDataSource  the device storage data source
         * *
         * @return the [TasksRepository] instance
         */
        @JvmStatic fun getInstance(tasksRemoteDataSource: BaseDataSource<Splash>,
                                   tasksLocalDataSource: BaseDataSource<Splash>): SplashRepository<Splash> {
            return INSTANCE
                    ?: SplashRepository(tasksRemoteDataSource, tasksLocalDataSource)
                    .apply { INSTANCE = this }
        }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}