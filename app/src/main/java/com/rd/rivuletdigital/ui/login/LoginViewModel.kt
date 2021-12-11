package com.rd.rivuletdigital.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rd.rivuletdigital.model.LoginModel
import com.rd.rivuletdigital.repository.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(var retrofitRepository: RetrofitRepository):ViewModel() {

    lateinit var logindata:MutableLiveData<LoginModel>

    init {
        logindata =  MutableLiveData<LoginModel>()
    }

     fun callUserLogin(email:String,password:String){
        retrofitRepository.userlogin(email,password,logindata)
    }

}