package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.Controller.DataController
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.Activities.View.Adapter.RestaurantsAdapter
import com.bounouamustapha.mata3im.Activities.View.ViewModel.RestaurantModel

import com.bounouamustapha.mata3im.R
import kotlinx.android.synthetic.main.fragment_detail_of_restaurant.*
import kotlinx.android.synthetic.main.fragment_list_of_restaurants.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val restaurantModel = ViewModelProviders.of(this).get(RestaurantModel::class.java)
        restaurantModel.restaurant = loadData()[0]

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        initialiseListRestaurentsFragment(restaurantModel, view)
        if (isTwoPane(view)) {
            initialiseDetailOfRestaurentsFragment(restaurantModel.restaurant, view)
        }


        return view
    }


    fun loadData(): List<Restaurant> {
        var dataRestaurant = DataController()
        return dataRestaurant.getRestaurants()
    }

    fun isTwoPane(v: View) = v.findViewById<View>(R.id.fragment_detail) != null


    fun initialiseListRestaurentsFragment(restaurantModel: RestaurantModel, v: View) {
        val restaurantsAdapter = RestaurantsAdapter(v.context, loadData())
        var listRestaurants= v.findViewById<ListView>(R.id.listRestaurants)
        listRestaurants.adapter = restaurantsAdapter
        listRestaurants.setOnItemClickListener { adapterView, view, i, l ->
            if (isTwoPane(v)) {
                // display detail data
                restaurantModel.restaurant = loadData()[i]
                initialiseDetailOfRestaurentsFragment(restaurantModel.restaurant,v)
            } else {
                // send the position to the detail activity
                //  startActivity(intentFor<DetailActivity>("pos" to i))
            }
        }


    }

    fun initialiseDetailOfRestaurentsFragment(restaurant: Restaurant, v: View) {
        var nameDetail= v.findViewById<TextView>(R.id.nameDetail)
        var imageDetail=v.findViewById<ImageView>(R.id.imageDetail)
        var description=v.findViewById<TextView>(R.id.description)
        nameDetail.text = restaurant.name
        imageDetail.setImageResource(R.drawable.istanbul_detail)
        description.text = restaurant.description
    }
}// Required empty public constructor
