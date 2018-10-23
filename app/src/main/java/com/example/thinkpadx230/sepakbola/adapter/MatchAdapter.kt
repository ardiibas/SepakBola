package com.example.thinkpadx230.sepakbola.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thinkpadx230.sepakbola.R
import com.example.thinkpadx230.sepakbola.model.LastMatch
import kotlinx.android.synthetic.main.item_list_match.view.*

class MatchAdapter(private val context: Context?, private val lastMatch: List<LastMatch>) : RecyclerView.Adapter<MatchViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MatchViewHolder =
            MatchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_match, p0, false))

    override fun getItemCount(): Int = lastMatch.size

    override fun onBindViewHolder(p0: MatchViewHolder, p1: Int) {
        p0.bindItem(lastMatch[p1])
    }

}

class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view){

    fun bindItem(lastMatch: LastMatch){
        itemView.item_list_name.text = lastMatch.strFilename
        itemView.item_list_home.text = lastMatch.strHomeTeam
        itemView.item_list_away.text = lastMatch.strAwayTeam
        itemView.item_list_score_home.text = lastMatch.intHomeScore
        itemView.item_list_score_away.text = lastMatch.intAwayScore
    }
}