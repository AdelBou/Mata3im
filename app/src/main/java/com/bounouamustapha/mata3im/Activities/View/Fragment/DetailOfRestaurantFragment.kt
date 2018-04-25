package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.Model.Restaurant

import com.bounouamustapha.mata3im.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.restaurant_item.*


@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 */
class DetailOfRestaurantFragment() : Fragment() {

    lateinit var v :View;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       var  v= inflater.inflate(R.layout.fragment_detail_of_restaurant, container, false)
        return v
    }

    companion object {
        fun newInstance (restaurant: Restaurant) :DetailOfRestaurantFragment{
            return DetailOfRestaurantFragment()
        }
    }


}// Required empty public constructor
