package com.epm.daggerprojectwithroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "logindetails")
//room behind the particular value
class LoginUserEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    val userId:Int=0,
    @ColumnInfo(name = "username")
    val userName:String,
    @ColumnInfo(name = "password")
    var userPassword:String

)