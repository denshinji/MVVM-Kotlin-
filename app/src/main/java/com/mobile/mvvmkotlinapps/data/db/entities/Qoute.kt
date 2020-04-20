package com.mobile.mvvmkotlinapps.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Qoute(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val qoute : String,
    val author : String,
    val thumbnail : String,
    val created_at : String,
    val update_at : String
) {
}