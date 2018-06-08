package com.lohas.lohas.data.source

/**
 * this BaseDataSource : 基础的数据处理接口
 * created by zaric on 2018-06-05 11:25
 */
interface BaseDataSource<T> {

    /**
     * 异步加载列表数据的接口
     */
    interface LoadCallback<T>{
        /**
         * 获取列表数据的方法
         */
        fun onLoaded(list:List<T>)

        /**
         * 没有数据
         */
        fun onDataNotAvailable()
    }

    /**
     * 异步获取单条数据
     */
    interface GetCallback<T>{
        /**
         * 获取列表数据的方法
         */
        fun onLoaded(data:T)

        /**
         * 没有数据
         */
        fun onDataNotAvailable()
    }

    /**
     * 获取列表数据
     */
    fun getList(callback: LoadCallback<T>)

    /**
     * 根据ID ，获取单条数据
     */
    fun getData(dataId: String, callback: GetCallback<T>)

    /**
     * 保存数据
     */
    fun save(data: T)

    /**
     * 更新数据
     */
    fun update(data: T)

    /**
     * 清空数据
     */
    fun clear()

    /**
     * 刷新数据
     */
    fun refresh()

    /**
     * 根据ID删除某一条数据
     */
    fun delete(dataId: String)
}