package com.bounouamustapha.mata3im.Activities.View.Fragment


import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bounouamustapha.mata3im.Activities.Model.Plat
import com.bounouamustapha.mata3im.Activities.View.ViewModel.PlatModel

import com.bounouamustapha.mata3im.R
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_menu_du_jour.view.*
import android.widget.Toast
import com.bounouamustapha.mata3im.Activities.Controller.Util
import com.joanzapata.iconify.IconDrawable
import com.joanzapata.iconify.fonts.FontAwesomeIcons
import com.joanzapata.iconify.fonts.IoniconsIcons
import com.yarolegovich.lovelydialog.LovelyTextInputDialog
import org.jetbrains.anko.support.v4.toast





@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 */
class MenuDuJourFragment(var p : Plat) : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v=inflater.inflate(R.layout.fragment_menu_du_jour, container, false)


        val platModel = ViewModelProviders.of(this).get(PlatModel::class.java)
        platModel.palt = p

        v.carouselViewDetailjour.setPageCount(platModel.palt.detailImage.size)
        var imageListener: ImageListener = object : ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView) {
                imageView.setImageResource(platModel.palt.detailImage[position])
            }
        }

        v.carouselViewDetailjour.setImageListener(imageListener)
        v.namePlatDetailjour.text = platModel.palt.name
        v.descriptionPlatDetailjour.text = platModel.palt.description
        v.categoryJour.text=platModel.palt.type
        if (platModel.palt.diabetique) v.diabetiqueDetailJour.visibility = View.GONE
        if (platModel.palt.binaire) v.binaireDetailjour.visibility = View.GONE
        if (platModel.palt.dujour) v.dujourDetailJour.visibility = View.GONE
        if (platModel.palt.vegetarien) v.vegetarienDetailjour.visibility = View.GONE

        if (platModel.palt.bookmark) {
            v.bookmarkDetailjour.setTextColor(getResources().getColor(R.color.colorRose))
        }
        else
        {
            v.bookmarkDetailjour.setTextColor(getResources().getColor(R.color.graycolorfonce))
        }
        if (platModel.palt.cart) {
            v.addCartDetailJour.setTextColor(getResources().getColor(R.color.colorRose))
        }
        else
        {
            v.addCartDetailJour.setTextColor(getResources().getColor(R.color.graycolorfonce))
        }


        v.bookmarkDetailjour.setOnClickListener(View.OnClickListener { i ->
            platModel.palt.bookmark = !platModel.palt.bookmark
            if (platModel.palt.bookmark) {
                v.bookmarkDetailjour.setTextColor(getResources().getColor(R.color.colorRose))
            }
            else
            {
                v.bookmarkDetailjour.setTextColor(getResources().getColor(R.color.graycolorfonce))
            }
        })

        v.priceDetailjourjour.text="${platModel.palt.prix}"+"{ion-social-usd}";

        v.addCartDetailJour.setOnClickListener(View.OnClickListener { i ->
            platModel.palt.cart = !platModel.palt.cart
            if (platModel.palt.cart) {
                v.addCartDetailJour.setTextColor(getResources().getColor(R.color.colorRose))
                Util.showCart(this!!.activity!!,plat =platModel.palt.name)
            }
            else
            {
                v.addCartDetailJour.setTextColor(getResources().getColor(R.color.graycolorfonce))
            }
        })




        v.buyPlatDetailJour.setOnClickListener({
            Util.showBuy(this!!.activity!!,plat =platModel.palt.name)
        })

        return  v
    }


}// Required empty public constructor
