package com.example.thinkpadx230.sepakbola.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.thinkpadx230.sepakbola.fragment.fragmentOne.FragmentOne
import com.example.thinkpadx230.sepakbola.fragment.fragmentTwo.FragmentTwo

class FragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(p0: Int): Fragment {
        return when (p0) {
            0 -> {
                FragmentOne()
            }
            1 -> {
                FragmentTwo()
            }
            else -> {
                FragmentOne()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Tab One"
            1 -> "Tab Two"
            else -> "Tab One"
        }
    }

}