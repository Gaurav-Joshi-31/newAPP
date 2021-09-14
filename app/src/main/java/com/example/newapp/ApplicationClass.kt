package com.example.newapp

import android.app.Application
import androidx.core.content.res.ResourcesCompat
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass: Application(){
    override fun onCreate() {
        super.onCreate()

        mInstance=this

    }


//    private fun configureToasty() {
//        ResourcesCompat.getFont(this, R.font.nunito)?.let {
//
//            Toasty.Config.getInstance()
//                .setToastTypeface(it)
//                .allowQueue(false) // optional (prevents several Toastys from queuing)
//                .apply()
//        } // required
//    }
    companion object {
        private lateinit var mInstance: ApplicationClass

        @Synchronized
        fun getInstance(): ApplicationClass {
            return mInstance
        }

    }
}