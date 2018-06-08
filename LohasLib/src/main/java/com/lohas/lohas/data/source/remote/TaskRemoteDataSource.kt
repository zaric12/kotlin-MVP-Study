package com.lohas.lohas.data.source.remote

import com.lohas.lohas.control.AppExecutors
import com.lohas.lohas.data.source.BaseDataSource

/**
 * this TaskRemoteDataSource :
 * created by zaric on 2018-06-07 13:30
 */
abstract class TaskRemoteDataSource<T>(val appExecutors: AppExecutors) : BaseDataSource<T>{
    override fun getList(callback: BaseDataSource.LoadCallback<T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getData(dataId: String, callback: BaseDataSource.GetCallback<T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(data: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(data: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(dataId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}