package com.epm.daggerprojectwithroom.di

import android.app.Application
import android.content.Context
import com.epm.daggerprojectwithroom.database.LoginDAO
import com.epm.daggerprojectwithroom.database.LoginDataBase
import com.epm.daggerprojectwithroom.database.LoginUserEntity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule (val application: Application){
    @Singleton
    @Provides
    fun getUserDAO(loginDataBase: LoginDataBase): LoginDAO {
        return loginDataBase.getLoginDAO()
    }

    @Singleton
    @Provides
    fun getRoomDbInstance():LoginDataBase{
        return LoginDataBase.getUserDatabase(providestheContex())
        //for getUserDatabase it requires contex
    }
    @Singleton
    @Provides
    fun providestheContex(): Context {
        return application.applicationContext
    }
}