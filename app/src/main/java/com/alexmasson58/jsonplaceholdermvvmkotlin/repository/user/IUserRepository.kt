package com.alexmasson58.jsonplaceholdermvvmkotlin.repository.user

import android.arch.lifecycle.LiveData
import com.alexmasson58.jsonplaceholdermvvmkotlin.model.User

/**
 * Created by frup66058 on 11/07/2018.
 */
interface IUserRepository {
    fun getUsers(): LiveData<List<User>>
    fun getUser(userId: Int): LiveData<User>
}