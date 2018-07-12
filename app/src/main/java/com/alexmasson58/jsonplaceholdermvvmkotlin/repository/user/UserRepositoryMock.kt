package com.alexmasson58.jsonplaceholdermvvmkotlin.repository.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.alexmasson58.jsonplaceholdermvvmkotlin.model.Address
import com.alexmasson58.jsonplaceholdermvvmkotlin.model.Compagny
import com.alexmasson58.jsonplaceholdermvvmkotlin.model.Geo
import com.alexmasson58.jsonplaceholdermvvmkotlin.model.User


/**
 * Created by frup66058 on 11/07/2018.
 */
class UserRepositoryMock : IUserRepository {
    override fun getUsers(): LiveData<List<User>> {

        val data = MutableLiveData<List<User>>()
        data.value = arrayListOf(getMockUser())
        return data
    }

    override fun getUser(userId: Int): LiveData<User> {
        val data = MutableLiveData<User>()
        data.value = getMockUser()
        return data
    }

    private fun getMockUser(): User {
        return User(1,
                "test",
                "username",
                "email@email.com",
                Address(
                        "rue XXX",
                        "",
                        "ORLEANS",
                        "45000",
                        Geo(
                                0.0,
                                65L)
                ),
                "0123456789",
                "www.website.com",
                Compagny(
                        "TheCo",
                        "Cogip bonjour!",
                        "Noone knows"
                )
        )
    }
}