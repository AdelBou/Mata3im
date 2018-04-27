package com.bounouamustapha.mata3im.Activities.View.Adapter

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.Controller.Util
import com.bounouamustapha.mata3im.Activities.Controller.Utils.OnPlatClickListner
import com.bounouamustapha.mata3im.Activities.Model.PlatBinaire
import com.bounouamustapha.mata3im.R
import com.joanzapata.iconify.widget.IconTextView

/**
 * Created by bounouamustapha on 4/1/18.
 */
class PlatBinaireAdapter(var c :Context, var listBinairePlats: List<PlatBinaire>, var listener: OnPlatClickListner) : RecyclerView.Adapter<PlatBinaireAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.txtName?.text = listBinairePlats[position].plat1.name +" "+listBinairePlats[position].plat2.name
        holder?.image1?.setImageResource(listBinairePlats[position].plat1.listImage)
        holder?.image2?.setImageResource(listBinairePlats[position].plat2.listImage)
        holder?.category?.text = listBinairePlats[position].plat1.type +" + "+listBinairePlats[position].plat2.type
        holder?.price?.text="${listBinairePlats[position].price}"+"{ion-social-usd}";
        holder?.bind(c, listBinairePlats.get(position), listener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_plat_binaire, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listBinairePlats.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.namePlatBinaire)
        val category = itemView.findViewById<TextView>(R.id.typeBinaire)
        val buy = itemView.findViewById<IconTextView>(R.id.buyPlatBinaire)
        var bookmark=itemView.findViewById<IconTextView>(R.id.bookmarkBinaire)
        var cart=itemView.findViewById<IconTextView>(R.id.addCartBinaire)
        val image1=itemView.findViewById<ImageView>(R.id.image1)
        val image2=itemView.findViewById<ImageView>(R.id.image2)
        var price=itemView.findViewById<IconTextView>(R.id.priceBinaire)
        fun bind(c:Context, item: PlatBinaire, listener: OnPlatClickListner) {
            image1.setOnClickListener{listener.onItemClick(item.plat1)}
            image2.setOnClickListener{listener.onItemClick(item.plat2)}
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
                    Util.showCart(c as Activity,item.plat1.name+" + "+item.plat2.name)
                }
                else
                {
                    cart.setTextColor(c.getResources().getColor(R.color.graycolorfonce))
                }
            })
            buy.setOnClickListener({
                Util.showBuy(c as Activity,item.plat1.name+" + "+item.plat2.name)
            })
        }
    }


}