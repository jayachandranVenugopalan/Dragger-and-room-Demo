package com.epm.daggerprojectwithroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [LoginUserEntity::class],version = 1)
abstract class LoginDataBase:RoomDatabase(){

        abstract fun getLoginDAO():LoginDAO

        companion object{
            private var db_instance:LoginDataBase?=null

            fun getUserDatabase(context: Context):LoginDataBase{

                if (db_instance==null){
                    db_instance= Room.databaseBuilder<LoginDataBase>(context.applicationContext,LoginDataBase::class.java,"user_db")
                        .allowMainThreadQueries()
                        .build()
                }
                return db_instance!!
            }
        }
}