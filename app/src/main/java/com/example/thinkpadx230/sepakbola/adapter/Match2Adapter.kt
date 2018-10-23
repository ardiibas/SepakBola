package com.example.thinkpadx230.sepakbola.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thinkpadx230.sepakbola.R
import com.example.thinkpadx230.sepakbola.model.NextMatch
import kotlinx.android.synthetic.main.item_list_match.view.*

class Match2Adapter(private val context: Context, private val nextMatch: List<NextMatch>) : RecyclerView.Adapter<Match2ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Match2ViewHolder =
            Match2ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_match, p0, false))

    override fun getItemCount(): Int = nextMatch.size

    override fun onBindViewHolder(p0: Match2ViewHolder, p1: Int) {
        p0.bindItem(nextMatch[p1])
    }

}

class Match2ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    fun bindItem(nextMatch: NextMatch){
        itemView.item_list_name.text = nextMatch.strFilename
        itemView.item_list_home.text = nextMatch.strHomeTeam
        itemView.item_list_away.text = nextMatch.strAwayTeam
        itemView.item_list_score_home.text = "0"
        itemView.item_list_score_away.text = "0"
    }
}