package com.example.thinkpadx230.sepakbola.fragment.fragmentOne

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thinkpadx230.sepakbola.R
import com.example.thinkpadx230.sepakbola.adapter.MatchAdapter
import com.example.thinkpadx230.sepakbola.model.LastMatch
import com.example.thinkpadx230.sepakbola.network.RepoAPI
import com.google.gson.Gson
import kotlinx.android.synthetic.main.frame_one.view.*

class FragmentOne : Fragment(), OneView {

    private var lastMatch1: MutableList<LastMatch> = mutableListOf()
    private lateinit var presenter: OnePresenter
    private lateinit var matchAdapter: MatchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.frame_one, container, false)

        matchAdapter = MatchAdapter(context, lastMatch1)
        rootView.recycler_one.adapter = matchAdapter

        val repoAPI = RepoAPI()
        val gson = Gson()

        presenter = OnePresenter(this, repoAPI, gson)
        presenter.getLastList()

        return rootView
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showLastList(lastMatch: List<LastMatch>) {
        lastMatch1.clear()
        lastMatch1.addAll(lastMatch)
        matchAdapter.notifyDataSetChanged()
    }
}