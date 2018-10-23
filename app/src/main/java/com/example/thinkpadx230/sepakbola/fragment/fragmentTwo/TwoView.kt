package com.example.thinkpadx230.sepakbola.fragment.fragmentTwo

import com.example.thinkpadx230.sepakbola.model.NextMatch

interface TwoView{
    fun showLoading()
    fun hideLoading()
    fun showNextList(data: List<NextMatch>)
}