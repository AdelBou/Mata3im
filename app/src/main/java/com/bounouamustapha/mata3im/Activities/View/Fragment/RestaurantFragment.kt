package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.annotation.SuppressLint
import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bounouamustapha.mata3im.Activities.Controller.DataController
import com.bounouamustapha.mata3im.Activities.Controller.Utils.OnItemClickListener
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.Activities.View.Adapter.RestaurantsAdapter
import com.bounouamustapha.mata3im.Activities.View.ViewModel.RestaurantModel
import com.bounouamustapha.mata3im.Activities.View.activity.ListRestaurantActivity
import com.bounouamustapha.mata3im.Activities.View.activity.MapsActivity
import com.bounouamustapha.mata3im.Activities.View.activity.RestaurantActivity

import com.bounouamustapha.mata3im.R
import com.synnapps.carouselview.CarouselView
import kotlinx.android.synthetic.main.fragment_detail_of_restaurant.*
import kotlinx.android.synthetic.main.fragment_list_of_restaurants.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_detail_of_restaurant.view.*
import org.jetbrains.anko.support.v4.*


@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 */
class RestaurantFragment (): Fragment() {
    lateinit  var nameDetail :TextView ;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val restaurantModel = ViewModelProviders.of(this).get(RestaurantModel::class.java)
        restaurantModel.restaurant = loadData()[0]
        activity!!.setTitle("Les restaurants traditionnels")
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        initialiseListRestaurentsFragment(restaurantModel, view)


        if (isTwoPane(view)) {
            initialiseDetailFrag(view,restaurantModel)

        }


        return view
    }


    fun loadData(): List<Restaurant> {
        var dataRestaurant = DataController()
        return dataRestaurant.getRestaurants()
    }

    fun isTwoPane(v: View) = v.findViewById<View>(R.id.fragment_detail) != null


    fun initialiseListRestaurentsFragment(restaurantModel: RestaurantModel, v: View) {
        val restaurantsAdapter = RestaurantsAdapter(v.context,
                loadData(), object : OnItemClickListener {
                 override fun onItemClick(item: Restaurant) {
                     if (isTwoPane(v)) {
                         restaurantModel.restaurant=item
                         initialiseDetailFrag(v,restaurantModel)
                     } else {
                         val intent = Intent(v.context, RestaurantActivity::class.java)
                         intent.putExtra("restaurant", item)
                         startActivity(intent)
                     }
            }

        })
        var listRestaurants = v.findViewById<RecyclerView>(R.id.listRestaurants)
        listRestaurants.adapter = restaurantsAdapter
        listRestaurants.layoutManager = LinearLayoutManager(v.context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
    }
/*
    fun initialiseDetailOfRestaurentsFragment(restaurant: Restaurant, v: View) {
      //  var nameDetail = v.findViewById<TextView>(R.id.nameDetail)
        var description = v.findViewById<TextView>(R.id.description)
        var carouselView = v.findViewById<CarouselView>(R.id.carouselView)
        carouselView.setPageCount(restaurant.detailImage.size)
        var imageListener: ImageListener = object : ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView) {
                imageView.setImageResource(restaurant.detailImage[position])
            }
        }
        carouselView.setImageListener(imageListener)
        nameDetail.text = "adel"
        description.text = "adel"
    }*/
fun initialiseDetailFrag(view :View ,restaurantModel :RestaurantModel){

    view.carouselViewDetail.setPageCount(restaurantModel.restaurant.detailImage.size)
    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(restaurantModel.restaurant.detailImage[position])
        }
    }
    view.carouselViewDetail.setImageListener(imageListener)
    view.nameDetailDetail.text = restaurantModel.restaurant.name
    view.descriptionDetail.text = restaurantModel.restaurant.description
    view.mailDetail.text=restaurantModel.restaurant.mail
    view.telDetail.text=restaurantModel.restaurant.tel
    view.adresseDetail.text=restaurantModel.restaurant.adresse
    view.facebookDetail.setOnClickListener({browse(restaurantModel.restaurant.facebook)})
    view.instagramDetail.setOnClickListener({browse(restaurantModel.restaurant.instagram)})
    view.twitterDetail.setOnClickListener({browse(restaurantModel.restaurant.twitter)})
    view.telDetail.setOnClickListener({makeCall(restaurantModel.restaurant.tel)})
    view.mailDetail.setOnClickListener({email(restaurantModel.restaurant.mail)})
    view.goplateDetail.setOnClickListener({toast("go to menus")})
    view.gomapDetail.setOnClickListener({
        val intent = Intent(context, MapsActivity::class.java)
        intent.putExtra("restaurant", restaurantModel.restaurant)
        startActivity(intent)})
    view.reserverDetail.setOnClickListener({toast("reserver")})
    view.shareDetail.setOnClickListener({share(restaurantModel.restaurant.name,restaurantModel.restaurant.description)})

    if (restaurantModel.restaurant.jaime) {
        view.jaime2Detail.setTextColor(getResources().getColor(R.color.colorRose));
    }
    else
    {
        view.jaime2Detail.setTextColor(getResources().getColor(R.color.graycolorfonce));
    }


    view.jaime2Detail.setOnClickListener({
        restaurantModel.restaurant.jaime = !restaurantModel.restaurant.jaime
        if (restaurantModel.restaurant.jaime) {
            restaurantModel.restaurant.nbJaime++
            view.jaime2Detail.setTextColor(getResources().getColor(R.color.colorRose))
            view.nbjaimedetailDetail.text= "${restaurantModel.restaurant.nbJaime}"
        }
        else
        {
            restaurantModel.restaurant.nbJaime--
            view.jaime2Detail.setTextColor(getResources().getColor(R.color.graycolorfonce))
            view.nbjaimedetailDetail.text= "${restaurantModel.restaurant.nbJaime}"

        }
    })















}


}// Required empty public constructor
