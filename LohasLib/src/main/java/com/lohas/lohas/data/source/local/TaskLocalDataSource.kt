package com.lohas.lohas.data.source.local

import android.support.annotation.VisibleForTesting
import com.lohas.lohas.control.AppExecutors
import com.lohas.lohas.data.Data
import com.lohas.lohas.data.source.BaseDataSource

/**
 * this TaskLocalDataSource :
 * created by zaric on 2018-06-07 13:34
 */
abstract class TaskLocalDataSource<T>(val appExecutors:  AppExecutors,val dao :BaseDao<T>) :BaseDataSource<T>{
    override fun getList(callback: BaseDataSource.LoadCallback<T>) {
        appExecutors.diskIO.execute{
            val tasks = dao.getList()
            appExecutors.mainThread.execute {
                if (tasks.isEmpty()) {
                    callback.onDataNotAvailable()
                } else {
                    callback.onLoaded(tasks)
                }
            }
        }
    }

    override fun getData(dataId: String, callback: BaseDataSource.GetCallback<T>) {
        appExecutors.diskIO.execute {
            val task = dao.getDataById(dataId)
            appExecutors.mainThread.execute {
                if (task != null) {
                    callback.onLoaded(task)
                } else {
                    callback.onDataNotAvailable()
                }
            }
        }
    }

    override fun save(data: T) {
        appExecutors.diskIO.execute{
            dao.insert(data)
        }
    }

    override fun update(data: T) {
       appExecutors.diskIO.execute { dao.update(data) }
    }

    override fun clear() {
        appExecutors.diskIO.execute { dao.deleteAll() }
    }

    override fun refresh() {

    }

    override fun delete(dataId: String) {
        appExecutors.diskIO.execute { dao.deleteById(dataId) }
    }


}