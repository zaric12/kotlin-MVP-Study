package com.lohas.lohas.data.source

import com.lohas.lohas.data.source.BaseDataSource
import java.util.ArrayList
import java.util.LinkedHashMap

/**
 * this BaseRepository : 基础的数据仓库
 * created by zaric on 2018-06-05 11:24
 * @param remoteDataSource 远程数据
 * @param localDataSource 本地数据
 */
abstract class BaseRepository<T>(val remoteDataSource:BaseDataSource<T>, val localDataSource: BaseDataSource<T>) :BaseDataSource<T>{

    /**
     * 公共数据缓存
     */
    var cachedData: LinkedHashMap<String, T> = LinkedHashMap()

    /**
     * 是否强制进行数据刷新  true 强制刷新
     */
    var isUpdateForce = false

    override fun getList(callback: BaseDataSource.LoadCallback<T>) {
        if (cachedData.isNotEmpty() && !isUpdateForce) {
            callback.onLoaded(ArrayList(cachedData.values))
            return
        }
        if (isUpdateForce){
            getDataFromRemoteDataSource(callback)
        }
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


    /**
     * 联网获取数据
     */
    private fun getDataFromRemoteDataSource(callback: BaseDataSource.LoadCallback<T>) {
        remoteDataSource.getList(object : BaseDataSource.LoadCallback<T> {
            override fun onLoaded(list: List<T>) {
                refreshCache(list)
                refreshLocalDataSource(list)
                callback.onLoaded(ArrayList(cachedData.values))
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    /**
     * 刷新缓存数据
     */
    private fun refreshCache(list: List<T>) {
        cachedData.clear()
        list.forEach {
            cacheAndPerform(it) {}
        }
        isUpdateForce = false
    }

    /**
     * 刷新本地数据
     */
    private fun refreshLocalDataSource(list: List<T>) {
        localDataSource.clear()
        for (data in list) {
            localDataSource.save(data)
        }
    }

    /**
     * 缓存执行
     */
    abstract fun cacheAndPerform(data: T, perform: (T) -> Unit)

}