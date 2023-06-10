package com.example.retrofitapitask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int =0
    @ColumnInfo(name = "Body")
    var body: String =""
    @ColumnInfo(name = "Title")
    var title: String = ""
    @ColumnInfo(name = "UserId")
    var userId: Int = 0
}