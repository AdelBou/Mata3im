package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.annotation.SuppressLint
import android.content.Intent
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
import com.bounouamustapha.mata3im.Activities.Controller.DataController
import com.bounouamustapha.mata3im.Activities.Controller.Utils.OnItemClickListener
import com.bounouamustapha.mata3im.Activities.Controller.Utils.OnPlatClickListner
import com.bounouamustapha.mata3im.Activities.Model.Plat
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.Activities.View.Adapter.PlatsAdapter
import com.bounouamustapha.mata3im.Activities.View.Adapter.RestaurantsAdapter
import com.bounouamustapha.mata3im.Activities.View.activity.PlatDetailActivity
import com.bounouamustapha.mata3im.Activities.View.activity.RestaurantActivity

import com.bounouamustapha.mata3im.R
import kotlinx.android.synthetic.main.fragment_menu_detail.view.*
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.toast
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
@SuppressLint("ValidFragment")
class MenuDetailFragment(var r : List<Plat>) : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v:View =inflater.inflate(R.layout.fragment_menu_detail, container, false)


        toast(r.size.toString())
        v.listPlat.adapter = PlatsAdapter(v.context,r,  object : OnPlatClickListner{
            override fun onItemClick(item: Plat) {
                val intent = Intent(v.context, PlatDetailActivity::class.java)
                intent.putExtra("plat", item)
                startActivity(intent)
            }
        })
        v.listPlat.layoutManager = GridLayoutManager(v.context, 2) as RecyclerView.LayoutManager?
       // v.listPlat.layoutManager= LinearLayoutManager(v.context, LinearLayout.VERTICAL, false)


        return  v
    }

}// Required empty public constructor
