package com.epm.daggerprojectwithroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epm.daggerprojectwithroom.database.LoginDAO
import com.epm.daggerprojectwithroom.database.LoginUserEntity
import com.epm.daggerprojectwithroom.repository.LoginRepository
import javax.inject.Inject

class MainViewModel(application: Application): AndroidViewModel(application) {
    @Inject
    lateinit var loginDAO: LoginDAO

    lateinit var alluserList: MutableLiveData<List<LoginUserEntity>>

    init {


        (application as MyApp).getAppComponent().inject1(this)

        alluserList= MutableLiveData()
        getAllRecord()
    }

    fun getRecordObserver(): MutableLiveData<List<LoginUserEntity>> {
        return alluserList
    }

    fun getAllRecord(){
        val list =loginDAO.registeruser()
        alluserList.postValue(list)
    }


    fun insertRecord(loginUserEntity: LoginUserEntity){
        loginDAO.insertOrUpdate(loginUserEntity)
        getAllRecord()
    }

}