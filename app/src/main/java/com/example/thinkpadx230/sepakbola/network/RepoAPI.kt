package com.example.thinkpadx230.sepakbola.network

import java.net.URL

class RepoAPI {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}