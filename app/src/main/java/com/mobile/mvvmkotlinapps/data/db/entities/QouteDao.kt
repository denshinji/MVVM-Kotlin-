package com.mobile.mvvmkotlinapps.data.db.entities

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QouteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQoute(qoutes : List<Qoute>)
    @Query("SELECT * FROM Qoute")
    fun getQoutes() : LiveData<List<Qoute>>
}