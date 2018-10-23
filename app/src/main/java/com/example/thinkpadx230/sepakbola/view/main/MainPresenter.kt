package com.example.thinkpadx230.sepakbola.view.main

import com.example.thinkpadx230.sepakbola.model.TeamResponse
import com.example.thinkpadx230.sepakbola.network.RepoAPI
import com.example.thinkpadx230.sepakbola.network.TheSportDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val repoAPI: RepoAPI,
                    private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(repoAPI
                    .doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}