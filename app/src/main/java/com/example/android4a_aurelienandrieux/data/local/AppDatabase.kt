package com.example.android4a_aurelienandrieux.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android4a_aurelienandrieux.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}