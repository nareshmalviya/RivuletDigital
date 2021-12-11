package com.rd.rivuletdigital.ui.projectlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.rd.rivuletdigital.databinding.ActivityProjectListBinding
import com.rd.rivuletdigital.model.LoginModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProjectListActivity : AppCompatActivity() {
    lateinit var binding: ActivityProjectListBinding
    lateinit var projectListViewModel: ProjectListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        projectListViewModel =ViewModelProvider(this).get(ProjectListViewModel::class.java)

        if (!intent.getStringExtra("logindata").isNullOrEmpty()){
            var logindata = Gson().fromJson(intent.getStringExtra("logindata"),LoginModel::class.java)
            Log.e("access_token",logindata.data.access_token)
            projectListViewModel.getprojectList(logindata.data.access_token)
        }




    }
}