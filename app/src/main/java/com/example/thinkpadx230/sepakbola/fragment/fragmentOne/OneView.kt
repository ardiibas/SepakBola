package com.example.thinkpadx230.sepakbola.fragment.fragmentOne

import com.example.thinkpadx230.sepakbola.model.LastMatch

interface OneView {
    fun showLoading()
    fun hideLoading()
    fun showLastList(lastMatch: List<LastMatch>)
}