package com.rd.rivuletdigital.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.rd.rivuletdigital.databinding.ActivityMainBinding
import com.rd.rivuletdigital.ui.projectlist.ProjectListActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


        CoroutineScope(Dispatchers.IO).launch {
            delay(1500)
            withContext(Dispatchers.Main){
                binding.splash.visibility =View.GONE
            }


        }

        binding.login.setOnClickListener { makelogin() }

        loginViewModel.logindata.observe(this, Observer {
            binding.progressbar.visibility =View.GONE

            if (it!=null){
                var logindata = it

                val intent = Intent(this, ProjectListActivity::class.java)
                intent.putExtra("logindata", Gson().toJson(logindata))
                startActivity(intent)



            }else{
                Toast.makeText(this,"Error from Network",Toast.LENGTH_SHORT).show()
            }

        })



    }

    private fun makelogin() {

        if (binding.username.text.toString().isEmpty()){
            binding.username.setError("PLease Fill Email")
        }else if (binding.password.text.toString().isEmpty()){
            binding.password.setError("PLease Fill Password")
        }else{
            binding.progressbar.visibility =View.VISIBLE
            loginViewModel.callUserLogin(binding.username.text.toString(),binding.password.text.toString())

        }
    }
}