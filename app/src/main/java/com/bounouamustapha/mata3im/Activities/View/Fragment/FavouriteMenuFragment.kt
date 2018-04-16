package com.bounouamustapha.mata3im.Activities.View.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounouamustapha.mata3im.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FavouriteMenuFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FavouriteMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavouriteMenuFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_menu, container, false)
    }

}// Required empty public constructor
