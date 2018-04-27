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
import com.bounouamustapha.mata3im.Activities.Model.Commande
import com.bounouamustapha.mata3im.Activities.Model.Plat
import com.bounouamustapha.mata3im.Activities.Model.PlatBinaire
import com.bounouamustapha.mata3im.R
import com.joanzapata.iconify.widget.IconTextView

/**
 * Created by bounouamustapha on 4/27/18.
 */

class CommandeAdapter(var c :Context, var listCommande: List<Commande>, var listener: OnPlatClickListner) : RecyclerView.Adapter<CommandeAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.namePlatPanier?.text = listCommande[position].plat.name
        holder?.panierImage?.setImageResource(listCommande[position].plat.listImage)
        holder?.price?.text="${listCommande[position].price}"+"{ion-social-usd}"
        holder?.resto?.text =listCommande[position].restaurant.name
        holder?.nb?.text ="${listCommande[position].nbPlats}"
        holder?.bind(c,listCommande.get(position), listener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.panier_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listCommande.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val panierImage=itemView.findViewById<ImageView>(R.id.panierImage)
        val namePlatPanier = itemView.findViewById<TextView>(R.id.namePlatPanier)
        val nb = itemView.findViewById<TextView>(R.id.nbPlat)
        var price=itemView.findViewById<IconTextView>(R.id.pricePanier)
        val confirme = itemView.findViewById<IconTextView>(R.id.confirmer)
        val delete = itemView.findViewById<IconTextView>(R.id.delete)
        val resto=itemView.findViewById<TextView>(R.id.restaurant)

        fun bind(c:Context, item: Commande, listener: OnPlatClickListner) {
        }
    }


}