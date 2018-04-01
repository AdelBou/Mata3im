package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounouamustapha.mata3im.R


/**
 * A simple [Fragment] subclass.
 */
class DetailOfRestaurantFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_of_restaurant, container, false)
    }

}// Required empty public constructor
