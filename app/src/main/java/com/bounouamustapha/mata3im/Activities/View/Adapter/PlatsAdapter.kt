package com.bounouamustapha.mata3im.Activities.View.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.Controller.Utils.OnPlatClickListner
import com.bounouamustapha.mata3im.Activities.Model.Plat
import com.bounouamustapha.mata3im.R
import com.joanzapata.iconify.widget.IconTextView

/**
 * Created by bounouamustapha on 4/1/18.
 */
class PlatsAdapter(var c :Context, var listPlats: List<Plat>, var listener: OnPlatClickListner) : RecyclerView.Adapter<PlatsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.txtName?.text = listPlats[position].name
        holder?.image?.setImageResource(listPlats[position].listImage)
        holder?.price?.text="${listPlats[position].prix}"+"{ion-social-usd}";
        holder?.bind(c,listPlats.get(position), listener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_plat, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listPlats.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.namePlat)
        val buy = itemView.findViewById<IconTextView>(R.id.buyPlat)
        var bookmark=itemView.findViewById<IconTextView>(R.id.bookmark)
        var cart=itemView.findViewById<IconTextView>(R.id.addCart)
        val image=itemView.findViewById<ImageView>(R.id.imagelistPlat)
        var price=itemView.findViewById<IconTextView>(R.id.price)
        var dujour=itemView.findViewById<IconTextView>(R.id.dujour)
        var vegetarien=itemView.findViewById<IconTextView>(R.id.vegetarien)
        var diabetique=itemView.findViewById<IconTextView>(R.id.diabetique)
        var binaire=itemView.findViewById<IconTextView>(R.id.binaire)

        fun bind(c:Context, item: Plat, listener: OnPlatClickListner) {
            if (!item.dujour) dujour.visibility=View.GONE
            if (!item.vegetarien) vegetarien.visibility=View.GONE
            if (!item.diabetique) diabetique.visibility=View.GONE
            if (!item.binaire) binaire.visibility=View.GONE

            image.setOnClickListener{listener.onItemClick(item)}
            txtName.setOnClickListener{listener.onItemClick(item)}

            if (item.bookmark) {
                bookmark.setTextColor(c.getResources().getColor(R.color.colorRose))
            }
            else
            {
                bookmark.setTextColor(c.getResources().getColor(R.color.graycolorfonce))
            }
            if (item.cart) {
                cart.setTextColor(c.getResources().getColor(R.color.colorRose))
            }
            else
            {
                cart.setTextColor(c.getResources().getColor(R.color.graycolorfonce))
            }


            bookmark.setOnClickListener(View.OnClickListener { i ->
                item.bookmark = !item.bookmark
                if (item.bookmark) {
                    bookmark.setTextColor(c.getResources().getColor(R.color.colorRose))
                }
                else
                {
                    bookmark.setTextColor(c.getResources().getColor(R.color.graycolorfonce))
                }
            })


            cart.setOnClickListener(View.OnClickListener { i ->
                item.cart = !item.cart
                if (item.cart) {
                    cart.setTextColor(c.getResources().getColor(R.color.colorRose))
                }
                else
                {
                    cart.setTextColor(c.getResources().getColor(R.color.graycolorfonce))
                }
            })
        }
    }


}