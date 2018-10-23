package com.example.thinkpadx230.sepakbola.view.main

import com.example.thinkpadx230.sepakbola.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}