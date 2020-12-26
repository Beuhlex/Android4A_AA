package com.example.android4a_aurelienandrieux.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.android4a_aurelienandrieux.data.local.models.UserLocal
import com.example.android4a_aurelienandrieux.domain.entity.User

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM userlocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM userlocal WHERE username LIKE :username AND password LIKE :password LIMIT 1")
    fun findByNameAndPassword(username: String, password: String): UserLocal?

    @Insert
    fun insert(user: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}