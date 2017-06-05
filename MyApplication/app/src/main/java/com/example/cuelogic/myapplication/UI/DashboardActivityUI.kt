package com.example.cuelogic.myapplication.UI


import android.view.*
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.*
import android.support.v7.widget.*
import android.widget.*
import org.jetbrains.anko.matchParent
import android.graphics.Color
import android.text.InputType
import android.util.Log
import com.example.cuelogic.myapplication.Avtivity.DashboardActivity
import com.example.cuelogic.myapplication.Adapter.DashboardAdapter
import com.example.cuelogic.myapplication.DataProvider.Product

import org.jetbrains.anko.*
import org.json.JSONObject
import java.net.URL

//import com.example.cuelogic.myapplication.UI.DashboardActivityUI.DashboardAdapter.LaunchMenuItemViewHolder

/**
 * Created by cuelogic on 05/04/17.
 */
class DashboardActivityUI: AnkoComponent<DashboardActivity> {
    lateinit var rcList: RecyclerView
    override fun createView(ui: AnkoContext<DashboardActivity>)=ui.apply {

        verticalLayout {
            rcList=recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = GridLayoutManager(ctx,2)

            }
        }


    }.view


}