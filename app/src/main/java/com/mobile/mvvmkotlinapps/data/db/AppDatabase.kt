package com.mobile.mvvmkotlinapps.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobile.mvvmkotlinapps.data.db.entities.Qoute
import com.mobile.mvvmkotlinapps.data.db.entities.QouteDao
import com.mobile.mvvmkotlinapps.data.db.entities.User
import com.mobile.mvvmkotlinapps.data.db.entities.UserDao

@Database(
    entities = [User::class,Qoute::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao() : UserDao
    abstract fun getQouteDao() : QouteDao

    companion object{
        @Volatile
        private var instance : AppDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context : Context) = instance?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db").build()

    }

}