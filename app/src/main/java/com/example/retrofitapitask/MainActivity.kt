package com.example.retrofitapitask

import CustomAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Array.newInstance


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var list: ArrayList<DataModelItem>
    lateinit var db: AddDb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.idRVCourse)
        db = Room.databaseBuilder(applicationContext, AddDb::class.java, "UserDb").build()

        list = ArrayList()

        val layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(list, this)
        recyclerView.layoutManager = layoutManager

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val api: RetrofitAPI = retrofit.create(RetrofitAPI::class.java)
        val call: Call<DataModel> = api.getAllData()

        call.enqueue(object : Callback<DataModel?> {
            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {

                if (response.isSuccessful) {
                    list.clear()
                    for (myData in response.body()!!) {

                        list.add(myData)
                        val thread = Thread {
                            var userEntity = UserEntity()
                            userEntity.id = myData.id
                            userEntity.body = myData.body
                            userEntity.title = myData.title
                            userEntity.userId = myData.userId

                            if (db.userDao().getAllData().isNotEmpty()) {
                                db.userDao().updateUserData(userEntity)
                            } else {
                                db.userDao().saveUserData(userEntity)
                            }
                        }
                        thread.start()
                    }

                    adapter.notifyDataSetChanged()
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<DataModel?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }

}

