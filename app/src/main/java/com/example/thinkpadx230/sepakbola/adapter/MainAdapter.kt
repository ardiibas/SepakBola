package com.example.thinkpadx230.sepakbola.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.thinkpadx230.sepakbola.R
import com.example.thinkpadx230.sepakbola.R.id.team_badge
import com.example.thinkpadx230.sepakbola.R.id.team_name
import com.example.thinkpadx230.sepakbola.model.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class MainAdapter(private val team: List<Team>) : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(
                AnkoContext.create(
                        p0.context, p0
                )
        ))
    }

    override fun getItemCount(): Int = team.size

    override fun onBindViewHolder(p0: TeamViewHolder, p1: Int) {
        p0.bindItem(team[p1])
    }

}

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val teamBagde: ImageView = view.find(team_badge)
    private val teamName: TextView = view.find(team_name)

    fun bindItem(team: Team) {
        Picasso.get().load(team.teamBadge).into(teamBagde)
        teamName.text = team.teamName
    }
}

class TeamUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.team_badge
                }.lparams {
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = R.id.team_name
                    textSize = 16f
                }.lparams {
                    margin = dip(15)
                }
            }
        }
    }

}