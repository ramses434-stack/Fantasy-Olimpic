package com.example.olimpicfantasy.data.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.olimpicfantasy.data.model.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity): Long

    @Query("SELECT * FROM usuarios WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): UserEntity?
}