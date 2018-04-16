package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.Controller.DataController
import com.bounouamustapha.mata3im.Activities.Model.Plat
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.Activities.View.Adapter.PlatsAdapter
import com.bounouamustapha.mata3im.Activities.View.Adapter.RestaurantsAdapter
import com.bounouamustapha.mata3im.Activities.View.ViewModel.PlatModel
import com.bounouamustapha.mata3im.Activities.View.ViewModel.RestaurantModel

import com.bounouamustapha.mata3im.R


/**
 * A simple [Fragment] subclass.
 */
class PlatesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val PlatesModel = ViewModelProviders.of(this).get(PlatModel::class.java)



        var view =inflater.inflate(R.layout.fragment_plates, container, false)

        var gridPlates= view.findViewById<GridView>(R.id.gridPlates)
        val platsAdapter = PlatsAdapter(view.context, loadData())
        gridPlates.adapter=platsAdapter


        return  view
    }

    fun loadData(): List<Plat> {
        var dataRestaurant = DataController()
        return dataRestaurant.getRestaurants()[0].listPlat
    }




}// Required empty public constructor
