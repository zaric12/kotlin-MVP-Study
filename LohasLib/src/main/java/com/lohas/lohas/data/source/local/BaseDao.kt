package com.lohas.lohas.data.source.local

import com.lohas.lohas.data.Data

/**
 * this BaseDao :
 * created by zaric on 2018-06-07 14:25
 */
interface BaseDao<T> {

    /**
     * 获取列表数据
     */
    fun getList():List<T>


    /**
     * 根据ID获取数据
     */
    fun getDataById(dataId:String):T

    /**
     * 插入一条数据
     */
    fun insert(data :T)


    /**
     * 更新数据
     */
    fun update(data:T)

    /**
     * 跟据ID删除数据
     */
    fun deleteById(dataId: String)

    /**
     * 清空表数据
     */
    fun deleteAll()

}