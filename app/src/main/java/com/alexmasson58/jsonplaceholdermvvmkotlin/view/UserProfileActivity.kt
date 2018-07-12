package com.alexmasson58.jsonplaceholdermvvmkotlin.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alexmasson58.jsonplaceholdermvvmkotlin.R
import com.alexmasson58.jsonplaceholdermvvmkotlin.application.MyApplication
import com.alexmasson58.jsonplaceholdermvvmkotlin.model.User
import com.alexmasson58.jsonplaceholdermvvmkotlin.viewmodel.UserProfileViewModel
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.address.*
import kotlinx.android.synthetic.main.compagny.*
import kotlinx.android.synthetic.main.geo.*

class UserProfileActivity : AppCompatActivity() {

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        val userId = 0
        viewModel.bind(userId, MyApplication.userRepository())
        viewModel.getUser().observe(this, Observer { user ->

            displayUser(user)
        })
    }

    private fun displayUser(user: User?) {
        if (user != null) {
            //updateUI
            userid.text = user.id.toString()

            name.text = user.name
            username.text = user.username
            email.text = user.email
            street.text = user.address.street
            suite.text = user.address.suite
            city.text = user.address.city
            zipcode.text = user.address.zipcode
            lat.text = user.address.geo.lat.toString()
            lng.text = user.address.geo.lng.toString()
            phone.text = user.phone
            website.text = user.website
            compagnyname.text = user.compagny.name
            catchPhrase.text = user.compagny.catchPhrase
            bs.text = user.compagny.bs

        }
    }

}
