package com.lohas.lohas.help.splash

import android.arch.persistence.room.*
import com.lohas.lohas.data.source.local.BaseDao
import com.lohas.lohas.help.data.Splash

/**
 * this SplashDao :
 * created by zaric on 2018-06-07 15:07
 */
@Dao interface SplashDao :BaseDao<Splash> {

    @Query("SELECT * FROM splash")
    override fun getList(): List<Splash>


    @Query("SELECT * FROM splash WHERE id=:dataId")
    override fun getDataById(dataId: String): Splash

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insert(data: Splash)

    @Update
    override fun update(data: Splash)

    @Query("DELETE FROM splash WHERE id = :dataId")
    override fun deleteById(dataId: String)


    @Query("DELETE FROM splash")
    override fun deleteAll()
}