package com.example.retrofitapitask

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    fun saveUserData(userEntity: UserEntity)

    @Query(value = "Select * from UserEntity")
    fun getAllData() : List<UserEntity>

    @Update
    fun updateUserData(userEntity: UserEntity)
}