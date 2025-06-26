package com.example.roomdatabasesample.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName")
    fun getUserByFirstName(firstName: String): UserEntity

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: UserEntity)

    @Delete
    fun removeUser(user: UserEntity)
}