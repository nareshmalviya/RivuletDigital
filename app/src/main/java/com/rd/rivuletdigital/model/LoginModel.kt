package com.rd.rivuletdigital.model

data class LoginModel(var status:Boolean,var workspace_id:String,var  data:dataLogin) {}
data class dataLogin(var access_token:String) {}