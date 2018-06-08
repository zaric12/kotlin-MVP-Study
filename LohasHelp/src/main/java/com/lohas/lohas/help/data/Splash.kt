package com.lohas.lohas.help.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.util.Log
import java.util.*
/**
 * 启动页数据库存储
 * created by zaric on 2018-06-05 15:57
 */
@Entity(tableName = "splash")
data class Splash @JvmOverloads constructor(
        @ColumnInfo(name = "title") var title: String = "",
        @ColumnInfo(name = "description") var description: String = "",
        @ColumnInfo(name = "content") var content : String = "",
        @ColumnInfo(name = "path") var path : String = "",
        @PrimaryKey @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString()
){

}