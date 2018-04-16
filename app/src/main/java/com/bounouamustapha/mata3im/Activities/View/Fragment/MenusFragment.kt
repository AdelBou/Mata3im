package com.bounouamustapha.mata3im.Activities.View.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounouamustapha.mata3im.R
import kotlinx.android.synthetic.main.fragment_menus.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MenusFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MenusFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenusFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_menus, container, false)


        return  view

    }


}
