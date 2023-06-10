package com.example.retrofitapitask

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [(UserEntity::class)],version = 1)
abstract class AddDb :RoomDatabase(){
    abstract fun userDao() : UserDao
}