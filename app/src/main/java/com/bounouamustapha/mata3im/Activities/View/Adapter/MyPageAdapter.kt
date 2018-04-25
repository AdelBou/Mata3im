package com.bounouamustapha.mata3im.Activities.View.Adapter


import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.bounouamustapha.mata3im.Activities.View.Fragment.MenuDetailFragment

import android.support.v4.app.Fragment
/**
 * Created by bounouamustapha on 4/25/18.
 */
class MyPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {
    internal val PAGE_COUNT = 6
    private val tabTitles = arrayOf("Menu du jour", "Menu Végétarien", "Menu Diabétique","Plats Binaires","Plats Unaires" ,"Tous les Plats")

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment? {
        return MenuDetailFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Generate title based on item position
        return tabTitles[position]
    }
}