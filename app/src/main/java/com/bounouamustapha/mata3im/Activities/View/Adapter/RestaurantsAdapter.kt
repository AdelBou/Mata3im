package com.bounouamustapha.mata3im.Activities.View.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.Controller.Utils.OnItemClickListener
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.R
import com.joanzapata.iconify.widget.IconTextView
import kotlinx.coroutines.experimental.newCoroutineContext
import org.jetbrains.anko.textColor

/**
 * Created by bounouamustapha on 4/1/18.
 */
class RestaurantsAdapter(var c :Context,var listRestaurants: List<Restaurant>, var listener: OnItemClickListener) : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.txtName?.text = listRestaurants[position].name
        holder?.nbjaime?.text = "${listRestaurants[position].nbJaime}  "+"{fa-thumbs-up}"
        holder?.image?.setImageResource(listRestaurants[position].listImage)
        // holder?.txtTitle?.text = listRestaurants[position].title
        holder?.bind(c,listRestaurants.get(position), listener)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.restaurant_item, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return listRestaurants.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.name)
        val jaime = itemView.findViewById<IconTextView>(R.id.jaime)
        val nbjaime=itemView.findViewById<IconTextView>(R.id.nbjaime)
        val detail=itemView.findViewById<TextView>(R.id.detail)
        val image=itemView.findViewById<ImageView>(R.id.imagelist)
        //   val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        public fun bind(c:Context,item: Restaurant, listener: OnItemClickListener) {
            if (detail!=null)
            detail.setOnClickListener { listener.onItemClick(item) }
            txtName.setOnClickListener { listener.onItemClick(item) }

            if (item.jaime) {
                jaime.setTextColor(c.getResources().getColor(R.color.colorRose));
            }
            else
            {
                jaime.setTextColor(c.getResources().getColor(R.color.graycolorfonce));
            }

            jaime.setOnClickListener(View.OnClickListener { i ->
                item.jaime = !item.jaime
                if (item.jaime) {
                    item.nbJaime++
                    jaime.setTextColor(c.getResources().getColor(R.color.colorRose))
                    nbjaime.text= "${item.nbJaime}  "+"{fa-thumbs-up}"
                }
                else
                {
                    item.nbJaime--
                    jaime.setTextColor(c.getResources().getColor(R.color.graycolorfonce))
                    nbjaime.text= "${item.nbJaime}  "+"{fa-thumbs-up}"
                }
            })
        }
    }

}