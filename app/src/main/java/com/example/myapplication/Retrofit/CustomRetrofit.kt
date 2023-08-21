package com.example.myapplication.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CustomRetrofit {
    companion object {
        var retrofit: Retrofit? = null
        var URL = "http://10.0.2.2:3118"
        var service: CustomService? = null
        fun getInstance(): Retrofit {

            retrofit = retrofit ?: Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build()) // <-- set log level
                .build()
            return retrofit!!
        }

        fun getInstanceService(): CustomService {
            if (service == null) {
                service = getInstance().create(CustomService::class.java)
            }
            return service!!
        }
    }
}