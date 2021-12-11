package com.rd.rivuletdigital.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.rd.rivuletdigital.model.LoginModel
import com.rd.rivuletdigital.model.ProjectListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository @Inject constructor(val retrofitService: RetrofitService) {


     fun userlogin(email: String, password: String, logindata: MutableLiveData<LoginModel>){

      var call:Call<LoginModel>?  =  retrofitService.userLogin(email,password)
        call?.enqueue(object :Callback<LoginModel>{
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {

                if (response.isSuccessful){
                    logindata.postValue(response.body())
                    Log.e("logindata",response.body().toString())
                }else{
                    logindata.postValue(null)
                }

            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                logindata.postValue(null)
            }
        })

    }



    fun getprojectlist( token :String, projectdata: MutableLiveData<ProjectListModel>, dummy :Array<String>){

        val header = HashMap<String, String>()
        header["Authorization"] = "Bearer "+token
        header["Content-Type"] = "application/json"


        var call:Call<ProjectListModel>?  =  retrofitService.getProjectList(header,
            dummy,dummy,"","","",
            "","",dummy,"","","","")
        call?.enqueue(object :Callback<ProjectListModel>{
            override fun onResponse(call: Call<ProjectListModel>, response: Response<ProjectListModel>) {

                if (response.isSuccessful){
                    projectdata.postValue(response.body())
                    Log.e("project",response.body().toString())
                }else{
                    projectdata.postValue(null)
                }
                Log.e("project",response.toString())
            }
            override fun onFailure(call: Call<ProjectListModel>, t: Throwable) {
                projectdata.postValue(null)
                Log.e("project",t.message.toString())
            }
        })

    }


}