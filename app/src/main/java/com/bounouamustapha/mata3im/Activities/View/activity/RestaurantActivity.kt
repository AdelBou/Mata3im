package com.bounouamustapha.mata3im.Activities.View.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.Activities.View.Fragment.*
import com.bounouamustapha.mata3im.R
import kotlinx.android.synthetic.main.activity_list_restaurant.*
import kotlinx.android.synthetic.main.activity_restaurants.*
import kotlinx.android.synthetic.main.app_bar_restaurants.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast
import android.graphics.Movie
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.View.ViewModel.RestaurantModel
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener


class RestaurantActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var r :Restaurant
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)
        setSupportActionBar(toolbar)
         r = intent.getSerializableExtra("restaurant") as Restaurant
        val restaurantModel = ViewModelProviders.of(this).get(RestaurantModel::class.java)
        restaurantModel.restaurant = r





        val toggle = ActionBarDrawerToggle(
                this, drawer_layoutRestaurant, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layoutRestaurant.addDrawerListener(toggle)
        toggle.syncState()

        nav_viewRestaurant.setNavigationItemSelectedListener(this)
        nav_viewRestaurant.setCheckedItem(R.id.ceRestaurant)
        onNavigationItemSelected(nav_viewRestaurant.getMenu().getItem(0))

        //added by adel



    }

    override fun onBackPressed() {
        if (drawer_layoutRestaurant.isDrawerOpen(GravityCompat.START)) {
            drawer_layoutRestaurant.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.restaurants, menu)
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
            R.id.ceRestaurant -> {

                fragmentTransaction.replace(R.id.fragmentRestaurants,CeRestaurantFragment(r)).commit()
              //  initialiseDetailOfRestaurentsFragment(r)
            }
            R.id.restaurants -> {
                startActivity(intentFor<ListRestaurantActivity>().singleTop())
            }
            R.id.favoriteCategories -> {
                fragmentTransaction.replace(R.id.fragmentRestaurants, MenuDetailFragment(r.listPlats.filter { s->s.bookmark })).commit()
            }
            R.id.panier -> {
                fragmentTransaction.replace(R.id.fragmentRestaurants, MenuDetailFragment(r.listPlats)).commit()
            }
            R.id.lesMenus -> {
                fragmentTransaction.replace(R.id.fragmentRestaurants, MenusFragment(r)).commit()
            }
            R.id.reserverUnetable-> {
                toast("reserver une table")
            }
            R.id.mesReservations -> {
                fragmentTransaction.replace(R.id.fragmentRestaurants, ReservationsFragment()).commit()
            }
            R.id.sommeNous-> {
                toast("I m zoubir")
            }
            R.id.contacter -> {
                toast("contacter nous")
            }

        }

        drawer_layoutRestaurant.closeDrawer(GravityCompat.START)
        return true
    }










}
