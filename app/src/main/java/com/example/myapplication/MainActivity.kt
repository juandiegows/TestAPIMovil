package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Retrofit.CustomRetrofit
import com.example.myapplication.adapter.StudentAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ConsumirAPI()
    }

    private fun ConsumirAPI() {
        CustomRetrofit.getInstanceService().getStudents().enqueue(
            object : Callback<List<Student>> {
                override fun onResponse(
                    call: Call<List<Student>>,
                    response: Response<List<Student>>
                ) {
                    var code = response.code()
                    var message = response.message()
                    Log.e("Data", "onResponse: $code $message ")
                    if (response.isSuccessful) {

                        var cuerpo = response.body()
                      binding.apply {
                          recycle.layoutManager = LinearLayoutManager(this@MainActivity)
                          recycle.adapter = StudentAdapter(cuerpo!!)
                      }
                    }
                }

                override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                    Log.e("Ocurrio un error", "onFailure: ${t.message}")
                }
            }
        )
    }
}