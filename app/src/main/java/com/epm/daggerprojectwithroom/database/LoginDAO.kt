package com.epm.daggerprojectwithroom.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface LoginDAO {

    @Query("SELECT *FROM logindetails ORDER BY userId DESC")
    fun registeruser():List<LoginUserEntity>?


    //@Query("SELECT *FROM logindetails WHERE userId=:userId")
//suspend fun getUserById(userId:Int):LoginUserEntity
//@Delete
//suspend fun deleteUser(loginUserEntity: LoginUserEntity)
    @Insert
    fun insertOrUpdate(entity: LoginUserEntity)
}