package com.bounouamustapha.mata3im.Activities.View.activity

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.widget.ImageView
import com.bounouamustapha.mata3im.Activities.Controller.Util
import com.bounouamustapha.mata3im.Activities.Model.Plat
import com.bounouamustapha.mata3im.Activities.View.ViewModel.PlatModel
import com.bounouamustapha.mata3im.Activities.View.ViewModel.RestaurantModel
import com.bounouamustapha.mata3im.R
import com.synnapps.carouselview.ImageListener

import kotlinx.android.synthetic.main.activity_plat_detail.*
import kotlinx.android.synthetic.main.content_plat_detail.*
import kotlinx.android.synthetic.main.fragment_ce_restaurant.view.*
import org.jetbrains.anko.support.v4.*

class PlatDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plat_detail)
        setSupportActionBar(toolbar)
        var p= intent.getSerializableExtra("plat") as Plat
        setTitle(p.name)
        val platModel = ViewModelProviders.of(this).get(PlatModel::class.java)
        platModel.palt = p

        carouselViewDetail.setPageCount(platModel.palt.detailImage.size)
        var imageListener: ImageListener = object : ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView) {
                imageView.setImageResource(platModel.palt.detailImage[position])
            }
        }
        
        carouselViewDetail.setImageListener(imageListener)
        namePlatDetail.text = platModel.palt.name
        descriptionPlatDetail.text = platModel.palt.description
        category.text=platModel.palt.type
        if (platModel.palt.diabetique) diabetiqueDetail.visibility = View.GONE
        if (platModel.palt.binaire) binaireDetail.visibility = View.GONE
        if (platModel.palt.dujour) dujourDetail.visibility = View.GONE
        if (platModel.palt.vegetarien) vegetarienDetail.visibility = View.GONE
        
        if (platModel.palt.bookmark) {
            bookmarkDetail.setTextColor(getResources().getColor(R.color.colorRose))
        }
        else
        {
            bookmarkDetail.setTextColor(getResources().getColor(R.color.graycolorfonce))
        }
        if (platModel.palt.cart) {
            addCartDetail.setTextColor(getResources().getColor(R.color.colorRose))
        }
        else
        {
            addCartDetail.setTextColor(getResources().getColor(R.color.graycolorfonce))
        }


        bookmarkDetail.setOnClickListener(View.OnClickListener { i ->
            platModel.palt.bookmark = !platModel.palt.bookmark
            if (platModel.palt.bookmark) {
                bookmarkDetail.setTextColor(getResources().getColor(R.color.colorRose))
            }
            else
            {
                bookmarkDetail.setTextColor(getResources().getColor(R.color.graycolorfonce))
            }
        })

          priceDetail.text="${platModel.palt.prix}"+"{ion-social-usd}";

        addCartDetail.setOnClickListener(View.OnClickListener { i ->
            platModel.palt.cart = !platModel.palt.cart
            if (platModel.palt.cart) {
                addCartDetail.setTextColor(getResources().getColor(R.color.colorRose))
                Util.showCart(this,platModel.palt.name)
            }
            else
            {
                addCartDetail.setTextColor(getResources().getColor(R.color.graycolorfonce))
            }
        })
        buyPlatDetail.setOnClickListener({
            Util.showBuy(this,platModel.palt.name)
        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  menuInflater.inflate(R.menu.list_restaurant, menu)
        return true
    }
}
