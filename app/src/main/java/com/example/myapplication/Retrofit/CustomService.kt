package com.example.myapplication.Retrofit

import com.example.myapplication.model.Student
import retrofit2.Call
import retrofit2.http.GET

interface CustomService {
    @GET("api/Student")
    fun getStudents():Call<List<Student>>
}