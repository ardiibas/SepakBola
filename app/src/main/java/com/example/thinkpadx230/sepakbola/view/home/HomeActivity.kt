package com.example.thinkpadx230.sepakbola.view.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.thinkpadx230.sepakbola.R
import com.example.thinkpadx230.sepakbola.adapter.FragmentAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        main_viewpager.adapter = fragmentAdapter

        main_tabs.setupWithViewPager(main_viewpager)
    }
}
