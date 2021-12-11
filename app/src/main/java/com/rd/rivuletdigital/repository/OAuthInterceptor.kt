package com.rd.rivuletdigital.repository

import okhttp3.Interceptor
import okhttp3.Response

class OAuthInterceptor(private val tokenType: String,private val access_token: String): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", "$tokenType $access_token").build()

        return chain.proceed(request)
    }


}
