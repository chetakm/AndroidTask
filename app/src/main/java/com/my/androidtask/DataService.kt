package com.my.androidtask

import android.icu.text.IDNA
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL="https://jsonplaceholder.typicode.com/"
interface DataInterface{

    @GET("posts")
    fun getData():Call<List<Info>>
}
object DataService{
    val datainstance:DataInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        datainstance=retrofit.create(DataInterface::class.java)
    }
}