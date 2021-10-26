package com.epm.daggerprojectwithroom

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.epm.daggerprojectwithroom.repository.LoginRepository
import java.lang.IllegalArgumentException

class MainViewModelFactory(var repository: LoginRepository,var application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

//       return MainViewModel(repository, application) as T
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java)->MainViewModel(application as Application) as T

            else->throw IllegalArgumentException("viewmodel is notfound")
        }

    }
}