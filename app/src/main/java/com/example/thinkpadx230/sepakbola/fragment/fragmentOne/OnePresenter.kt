package com.example.thinkpadx230.sepakbola.fragment.fragmentOne

import com.example.thinkpadx230.sepakbola.model.LastRespone
import com.example.thinkpadx230.sepakbola.network.RepoAPI
import com.example.thinkpadx230.sepakbola.network.TheSportDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class OnePresenter(
        private val oneView: OneView,
        private val repoAPI: RepoAPI,
        private val gson: Gson
) {
    fun getLastList() {
        oneView.showLoading()
        doAsync {
            val last = gson.fromJson(
                    repoAPI.doRequest(
                            TheSportDBApi.getLastMatch()),
                    LastRespone::class.java
            )

            uiThread {
                oneView.hideLoading()
                oneView.showLastList(last.lastMatch)
            }
        }
    }
}