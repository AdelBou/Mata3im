package com.bounouamustapha.mata3im.Activities.View.Fragment

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.fragment_menus.view.*
import android.support.v4.view.ViewPager
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.Activities.View.Adapter.MyPagerAdapter
import com.joanzapata.iconify.IconDrawable
import com.joanzapata.iconify.fonts.FontAwesomeIcons
import com.joanzapata.iconify.fonts.IoniconsIcons


@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MenusFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MenusFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenusFragment (var r:Restaurant): Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_menus, container, false)
        view.container.adapter =MyPagerAdapter(r,activity!!.getSupportFragmentManager(), this!!.context!!)
        view.tabs.setupWithViewPager(view.container)

        view.tabs.getTabAt(0)!!.setIcon(IconDrawable(activity, IoniconsIcons.ion_fireball).colorRes(R.color.colorRose).sizeDp(50))
        view.tabs.getTabAt(1)!!.setIcon(IconDrawable(activity, IoniconsIcons.ion_leaf).colorRes(R.color.colorRose).sizeDp(50))
        view.tabs.getTabAt(2)!!.setIcon(IconDrawable(activity, FontAwesomeIcons.fa_plus).colorRes(R.color.colorRose).sizeDp(50))
        view.tabs.getTabAt(3)!!.setIcon(IconDrawable(activity, IoniconsIcons.ion_pricetags).colorRes(R.color.colorRose).sizeDp(50))
        view.tabs.getTabAt(4)!!.setIcon(IconDrawable(activity, IoniconsIcons.ion_arrow_down_c).colorRes(R.color.colorRose).sizeDp(50))
        view.tabs.getTabAt(5)!!.setIcon(IconDrawable(activity, IoniconsIcons.ion_bonfire).colorRes(R.color.colorRose).sizeDp(50))
        view.tabs.getTabAt(6)!!.setIcon(IconDrawable(activity, FontAwesomeIcons.fa_birthday_cake).colorRes(R.color.colorRose).sizeDp(50))


        activity!!.setTitle("Nos Plats")
        return  view

    }



}
