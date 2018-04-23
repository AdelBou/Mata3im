package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bounouamustapha.mata3im.Activities.Controller.DataController
import com.bounouamustapha.mata3im.Activities.Controller.Utils.OnItemClickListener
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.Activities.View.Adapter.RestaurantsAdapter
import com.bounouamustapha.mata3im.Activities.View.ViewModel.RestaurantModel
import com.bounouamustapha.mata3im.Activities.View.activity.ListRestaurantActivity
import com.bounouamustapha.mata3im.Activities.View.activity.RestaurantActivity

import com.bounouamustapha.mata3im.R
import com.synnapps.carouselview.CarouselView
import kotlinx.android.synthetic.main.fragment_detail_of_restaurant.*
import kotlinx.android.synthetic.main.fragment_list_of_restaurants.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.toast
import com.synnapps.carouselview.ImageListener




/**
 * A simple [Fragment] subclass.
 */
class RestaurantFragment : Fragment() {
    lateinit  var nameDetail :TextView ;

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
        val restaurantsAdapter = RestaurantsAdapter(v.context,
                loadData(), object : OnItemClickListener {
                 override fun onItemClick(item: Restaurant) {
                     toast(item.name)
                     if (isTwoPane(v)) {
                         // display detail data
                         restaurantModel.restaurant = item
                         initialiseDetailOfRestaurentsFragment(restaurantModel.restaurant,v)
                     } else {
                         val intent = Intent(v.context, RestaurantActivity::class.java)
                         intent.putExtra("restaurant", item)
                         startActivity(intent)
                        // startActivity(intentFor<RestaurantActivity>().singleTop())
                         // send the position to the detail activity

                     }
            }

        })
        var listRestaurants = v.findViewById<RecyclerView>(R.id.listRestaurants)
        listRestaurants.adapter = restaurantsAdapter
        listRestaurants.layoutManager = LinearLayoutManager(v.context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
    }

    fun initialiseDetailOfRestaurentsFragment(restaurant: Restaurant, v: View) {
      //  var nameDetail = v.findViewById<TextView>(R.id.nameDetail)

        var description = v.findViewById<TextView>(R.id.description)
        var carouselView = v.findViewById<CarouselView>(R.id.carouselView)
        carouselView.setPageCount(restaurant.detailImage.size)
        var imageListener: ImageListener = object : ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView) {
                imageView.setImageResource(restaurant.detailImage[position])
            }
        }
        carouselView.setImageListener(imageListener)
        nameDetail.text = "adel"
        description.text = "adel"
    }



}// Required empty public constructor
