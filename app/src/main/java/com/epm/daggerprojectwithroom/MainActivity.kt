package com.epm.daggerprojectwithroom

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.epm.daggerprojectwithroom.database.LoginUserEntity
import com.epm.daggerprojectwithroom.databinding.ActivityMainBinding
import com.epm.daggerprojectwithroom.repository.LoginRepository

class MainActivity : AppCompatActivity() {
    private lateinit var loginViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private  var mainViewModelFactory=MainViewModelFactory(LoginRepository(), Application())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.login.setOnClickListener {
                      val userEntity= LoginUserEntity(userName = binding.username.text.toString(),userPassword = binding.password.text.toString())
            loginViewModel.insertRecord(userEntity)
           binding.resultvalue.text=""

       }



        initVIewModel()

    }


    private fun initVIewModel(){
        loginViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        loginViewModel.getRecordObserver().observe(this,object :Observer<List<LoginUserEntity>>
            {
                override fun onChanged(t: List<LoginUserEntity>?) {
                    binding.resultvalue.text=""
                    t?.forEach {
                       binding.resultvalue.append(it.userName+"\n")
                    }
                }
            })
    }
}