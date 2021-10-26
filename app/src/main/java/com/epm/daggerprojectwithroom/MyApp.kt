package com.epm.daggerprojectwithroom

import android.app.Activity
import android.app.Application
import com.epm.daggerprojectwithroom.di.AppComponent
import com.epm.daggerprojectwithroom.di.AppModule
import com.epm.daggerprojectwithroom.di.DaggerAppComponent
import javax.inject.Inject

class MyApp:Application (){

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
      appComponent=  DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()



    }
    fun getAppComponent():AppComponent{
        return appComponent
    }
}