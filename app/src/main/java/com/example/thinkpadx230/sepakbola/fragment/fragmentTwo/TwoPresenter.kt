package com.example.thinkpadx230.sepakbola.fragment.fragmentTwo

import com.example.thinkpadx230.sepakbola.model.NextRespone
import com.example.thinkpadx230.sepakbola.network.RepoAPI
import com.example.thinkpadx230.sepakbola.network.TheSportDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TwoPresenter(private val twoView: TwoView,
                   private val repoAPI: RepoAPI,
                   private val gson: Gson) {

    fun getNextList() {
        twoView.showLoading()
        doAsync {
            val data = gson.fromJson(repoAPI
                    .doRequest(TheSportDBApi.getNextMatch()),
                    NextRespone::class.java
            )

            uiThread {
                twoView.hideLoading()
                twoView.showNextList(data.nextMatch)
            }
        }
    }
}