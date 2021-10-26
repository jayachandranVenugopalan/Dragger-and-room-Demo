package com.epm.daggerprojectwithroom.di


import com.epm.daggerprojectwithroom.MainViewModel

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject1(app: MainViewModel)



   }