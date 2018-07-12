package com.alexmasson58.jsonplaceholdermvvmkotlin.repository.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.alexmasson58.jsonplaceholdermvvmkotlin.application.MyApplication
import com.alexmasson58.jsonplaceholdermvvmkotlin.model.User
import com.alexmasson58.jsonplaceholdermvvmkotlin.service.Webservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Alexandre MASSON on 12/07/2018.
 */
class UserRepository : IUserRepository {
    private val webservice: Webservice = MyApplication.service()
    override fun getUsers(): LiveData<List<User>> {
        val data = MutableLiveData<List<User>>()
        webservice.getUserList().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                data.value = ArrayList<User>()
            }

            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                data.value = ArrayList<User>()

                if (response != null && response.isSuccessful) {
                    data.value = response.body()
                }

            }

        })
        return data

    }

    override fun getUser(userId: Int): LiveData<User> {
        // This is not an optimal implementation, we'll fix it below
        val data = MutableLiveData<User>()

        webservice.getUser(userId).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                // error case is left out for brevity
                data.value = response.body()
            }
        })
        return data
    }

}