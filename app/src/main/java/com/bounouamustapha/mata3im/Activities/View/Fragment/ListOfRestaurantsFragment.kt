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
class ListOfRestaurantsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        activity!!.setTitle("Les restaurants traditionnels")
        return inflater.inflate(R.layout.fragment_list_of_restaurants, container, false)

    }

}// Required empty public constructor
