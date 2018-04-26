package com.bounouamustapha.mata3im.Activities.View.Adapter


import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.bounouamustapha.mata3im.Activities.View.Fragment.MenuDetailFragment

import android.support.v4.app.Fragment
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import org.jetbrains.anko.toast

/**
 * Created by bounouamustapha on 4/25/18.
 */
class MyPagerAdapter(var r:Restaurant,fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {
    internal val PAGE_COUNT = 6
    private val tabTitles = arrayOf("Menu du jour", "Menu Végétarien", "Menu Diabétique","Plats Binaires","Plats Unaires" ,"Tous les Plats")

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {println("hoho"+r.listPlats.toString())
                return   MenuDetailFragment(r.listPlats.filter { s-> s.dujour })}

            1 ->  {print("tab2"+r.listPlats.toString())
                return   MenuDetailFragment(r.listPlats.filter { s-> s.vegetarien })}
            2 -> {print("tab3"+r.listPlats.toString())
                return  MenuDetailFragment(r.listPlats.filter { s-> s.diabetique})}
            3 -> {print("tab4"+r.listPlats.toString())
                return  MenuDetailFragment(r.listPlats.filter { s-> s.binaire})}
            4 ->   {print("tab5"+r.listPlats.toString())
                return  MenuDetailFragment(r.listPlats.filter { s-> !s.binaire})}
            5 ->   {print("tab6"+r.listPlats.toString())
                return  MenuDetailFragment(r.listPlats)}
            else ->  {print("autre"+r.listPlats.toString())
                return MenuDetailFragment(r.listPlats)}
        }

    }
    override fun getPageTitle(position: Int): CharSequence? {
        // Generate title based on item position
        return tabTitles[position]
    }
}