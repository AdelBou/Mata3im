package com.bounouamustapha.mata3im.Activities.View.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bounouamustapha.mata3im.Activities.Controller.DataController
import com.bounouamustapha.mata3im.Activities.View.Fragment.*
import com.bounouamustapha.mata3im.R
import kotlinx.android.synthetic.main.activity_list_restaurant.*
import kotlinx.android.synthetic.main.app_bar_list_restaurant.*
import org.jetbrains.anko.toast
import com.joanzapata.iconify.fonts.FontAwesomeIcons
import com.joanzapata.iconify.IconDrawable
import com.joanzapata.iconify.fonts.IoniconsIcons


class ListRestaurantActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_restaurant)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        var color=R.color.colorRose
        nav_view.getMenu().findItem(R.id.restaurants).setIcon(IconDrawable(this, IoniconsIcons.ion_android_restaurant).colorRes(color).sizeDp(50))
        nav_view.getMenu().findItem(R.id.mesReservations).setIcon(IconDrawable(this, IoniconsIcons.ion_calendar).colorRes(color).sizeDp(50))
        nav_view.getMenu().findItem(R.id.favoriteCategories).setIcon(IconDrawable(this, IoniconsIcons.ion_star).colorRes(color).sizeDp(50))
        nav_view.getMenu().findItem(R.id.panier).setIcon(IconDrawable(this, IoniconsIcons.ion_android_cart).colorRes(color).sizeDp(50))
        nav_view.getMenu().findItem(R.id.sommeNous).setIcon(IconDrawable(this, IoniconsIcons.ion_information_circled).colorRes(color).sizeDp(50))
        nav_view.getMenu().findItem(R.id.contacter).setIcon(IconDrawable(this, IoniconsIcons.ion_paper_airplane).colorRes(color).sizeDp(50))




        nav_view.setNavigationItemSelectedListener(this)

        nav_view.setCheckedItem(R.id.restaurants)
        onNavigationItemSelected(nav_view.getMenu().getItem(0))
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  menuInflater.inflate(R.menu.list_restaurant, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.restaurants -> {
                fragmentTransaction.replace(R.id.fragmentListRestaurants, RestaurantFragment()).commit()
            }
            R.id.favoriteCategories -> {
                fragmentTransaction.replace(R.id.fragmentListRestaurants, MenuDetailFragment(DataController().getRestaurants().get(0).listPlats.filter { s->s.bookmark })).commit()
            }
            R.id.panier -> {
                fragmentTransaction.replace(R.id.fragmentListRestaurants, PanierFragment()).commit()
            }
            R.id.mesReservations -> {
                fragmentTransaction.replace(R.id.fragmentListRestaurants, ReservationsFragment()).commit()
            }
            R.id.sommeNous-> {
                toast("I m zoubir")
            }
            R.id.contacter -> {
                toast("contacter nous")
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
