package com.example.thinkpadx230.sepakbola.view.main

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.example.thinkpadx230.sepakbola.R.array.league
import com.example.thinkpadx230.sepakbola.R.color.colorAccent
import com.example.thinkpadx230.sepakbola.model.Team
import com.example.thinkpadx230.sepakbola.network.RepoAPI
import com.example.thinkpadx230.sepakbola.util.invisible
import com.example.thinkpadx230.sepakbola.util.visible
import com.example.thinkpadx230.sepakbola.adapter.MainAdapter
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class MainActivity : AppCompatActivity(), MainView {

    private var team: MutableList<Team> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter

    private lateinit var listTeam: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var spinner: Spinner

    private lateinit var ligaName: String

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout {
            lparams (width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)

            spinner = spinner ()
            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                relativeLayout{
                    lparams (width = matchParent, height = wrapContent)

                    listTeam = recyclerView {
                        lparams (width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }

                    progressBar = progressBar {
                    }.lparams{
                        centerHorizontally()
                    }
                }
            }
        }

        adapter = MainAdapter(team)
        listTeam.adapter = adapter

        val  request = RepoAPI()
        val  gson = Gson()
        presenter = MainPresenter(this, request, gson)

        val spinnerItem = resources.getStringArray(league)
        val spinnerAdapter = ArrayAdapter(
                ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItem
        )
        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                ligaName = spinner.selectedItem.toString()
                presenter.getTeamList(ligaName)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        swipeRefresh.onRefresh { presenter.getTeamList(ligaName) }
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showTeamList(data: List<Team>) {
        swipeRefresh.isRefreshing = false
        team.clear()
        team.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
