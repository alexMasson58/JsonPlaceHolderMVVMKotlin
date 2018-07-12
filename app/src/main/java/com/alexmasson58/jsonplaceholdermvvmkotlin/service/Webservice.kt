package com.alexmasson58.jsonplaceholdermvvmkotlin.service

import com.alexmasson58.jsonplaceholdermvvmkotlin.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by frup66058 on 12/07/2018.
 */
interface Webservice {

    @GET("users")
    fun getUserList(): Call<List<User>>

    @GET("users/{id}")
    fun getUser(@Path("id") userid: Int): Call<User>



}