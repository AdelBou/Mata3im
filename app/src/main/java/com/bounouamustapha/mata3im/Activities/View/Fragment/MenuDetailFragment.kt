package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout

import com.bounouamustapha.mata3im.R


/**
 * A simple [Fragment] subclass.
 */
class MenuDetailFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v:View =inflater.inflate(R.layout.fragment_menu_detail, container, false)

        var listPlat = v.findViewById<RecyclerView>(R.id.listPlat)
        listPlat.adapter = PlatsAdapter
        listPlat.layoutManager = GridLayoutManager(v.context, 2) as RecyclerView.LayoutManager?



        return  v
    }

}// Required empty public constructor
