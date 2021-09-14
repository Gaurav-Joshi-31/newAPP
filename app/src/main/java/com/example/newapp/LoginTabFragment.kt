package com.example.newapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_login_tab.*

class LoginTabFragment : Fragment(R.layout.fragment_login_tab) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textEmailAddress.translationX=300F
        textPassword.translationX=300F
        btnLogin.translationX=300F


        textEmailAddress.alpha=0F
        textPassword.alpha=0F
        btnLogin.alpha=0F

        textEmailAddress.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(300).start()
        textPassword.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(500).start()
        btnLogin.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(700).start()

    }

}