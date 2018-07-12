package com.alexmasson58.jsonplaceholdermvvmkotlin.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexmasson58.jsonplaceholdermvvmkotlin.model.User
import com.alexmasson58.jsonplaceholdermvvmkotlin.repository.user.IUserRepository


/**
 * Created by frup66058 on 11/07/2018.
 */
class UserProfileViewModel : ViewModel() {
    private var user: LiveData<User>? = null
    private lateinit var userRepo: IUserRepository


    fun bind(userId: Int, repository: IUserRepository) {
        if (this.user != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return
        }
        this.userRepo = repository
        user = userRepo.getUser(userId.toInt())
    }

    fun getUser(): LiveData<User>? {
        return this.user
    }
}