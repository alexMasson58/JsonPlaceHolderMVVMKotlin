package com.alexmasson58.jsonplaceholdermvvmkotlin.application

import android.app.Application
import com.alexmasson58.jsonplaceholdermvvmkotlin.repository.user.IUserRepository
import com.alexmasson58.jsonplaceholdermvvmkotlin.repository.user.UserRepositoryMock
import com.alexmasson58.jsonplaceholdermvvmkotlin.service.Webservice
import retrofit2.Retrofit


/**
 * Created by frup66058 on 11/07/2018.
 */


class MyApplication : Application() {
    companion object {
        private val userRepo = UserRepositoryMock()
        private var service: Webservice? = null
        private val baseUrl = "https://jsonplaceholder.typicode.com/"
        fun userRepository(): IUserRepository {
            return userRepo
        }

        fun service(): Webservice {
            if (service == null) {
                val retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .build()

                service = retrofit.create<Webservice>(Webservice::class.java)
            }
            return service!!
        }
    }
}