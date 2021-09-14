package com.example.newapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.newapp.adapters.LoginViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val adapter= LoginViewPagerAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter=adapter
        TabLayoutMediator(tab,viewpager){tab,position ->
            when(position){
                0->{
                    tab.text="Login"
                }
                1->{
                    tab.text="Sign Up"
                }

            }

        }.attach()

        fb_fab.translationY=300F
        google_fab.translationY=300F
        tab.translationX=300F


        fb_fab.alpha=0F
        google_fab.alpha=0F
        tab.alpha=0F



        fb_fab.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(500).start()
        google_fab.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(700).start()
        tab.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(150).start()


    }
}