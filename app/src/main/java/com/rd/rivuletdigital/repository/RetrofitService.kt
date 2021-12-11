package com.rd.rivuletdigital.repository

import com.rd.rivuletdigital.model.LoginModel
import com.rd.rivuletdigital.model.ProjectListModel
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @POST("mobile-pm/login")
    fun userLogin (@Query("email") email:String, @Query("password") password:String ) :Call<LoginModel>?


    @POST("mobile-pm/project/all-list")
    fun getProjectList (
        @HeaderMap headers: Map<String, String> ,
                               @Query("workspace_id[]") workspace_id: Array<String> ,
                               @Query("client_id[]") client_id:Array<String>,
                               @Query("sortvalue") sortvalue:String,
                               @Query("orderby") orderby:String,
                               @Query("search_value") search_value:String,
                               @Query("favourite_project") favourite_project:String,
                               @Query("recent_project") recent_project:String,
                               @Query("project_owner_id[]") project_owner_id:Array<String>,
                               @Query("archive_project") archive_project:String,
                               @Query("is_collaborate") is_collaborate:String,
                               @Query("status_id") status_id:String,
                               @Query("page") page:String
    ) :Call<ProjectListModel>?


    @Multipart
    @POST("mobile-pm/project/assets/list")
    suspend fun getassetList (@Path("project_id") project_id: String ,
                               @Path("workspace_id") workspace_id:String
    ) :Call<LoginModel>?




}