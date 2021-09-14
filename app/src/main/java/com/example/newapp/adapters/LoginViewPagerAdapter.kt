package com.example.newapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newapp.LoginTabFragment
import com.example.newapp.SignupTabFragment

class LoginViewPagerAdapter(

    fragmentManager: FragmentManager,
    lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 ->{
               LoginTabFragment()
           }
           1 ->{
               SignupTabFragment()
           }
           else -> {
               Fragment()
           }
       }
    }
}