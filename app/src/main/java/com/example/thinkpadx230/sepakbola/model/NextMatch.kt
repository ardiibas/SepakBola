package com.example.thinkpadx230.sepakbola.model

import com.google.gson.annotations.SerializedName

data class NextMatch(
        @SerializedName("idEvent")
        var idEvent: String? = null,

        @SerializedName("idSoccerXML")
        var idSoccerXML: String? = null,

        @SerializedName("strEvent")
        var strEvent: String? = null,

        @SerializedName("strFilename")
        var strFilename: String? = null,

        @SerializedName("strHomeTeam")
        var strHomeTeam: String? = null,

        @SerializedName("strAwayTeam")
        var strAwayTeam: String? = null
)