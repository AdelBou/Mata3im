package com.bounouamustapha.mata3im.Activities.View.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.R

/**
 * Created by bounouamustapha on 4/1/18.
 */
class RestaurantsAdapter(_ctx: Context, listRestaurants:List<Restaurant>): BaseAdapter() {
    var ctx = _ctx
    val listRestaurant = listRestaurants


    override fun getItem(p0: Int) = listRestaurant.get(p0)

    override fun getItemId(p0: Int) = listRestaurant.get(p0).hashCode().toLong()

    override fun getCount()= listRestaurant.size

    override fun getView(position: Int, p0: View?, parent: ViewGroup?): View {
        var view = p0
        var viewHolder: ViewHolder
        if(view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.restaurant_item,parent,false)
            val imageList = view?.findViewById<ImageView>(R.id.listimage) as ImageView
            val name = view?.findViewById<TextView>(R.id.name) as TextView
            val numberTourist = view?.findViewById<TextView>(R.id.numbertourist) as TextView
            viewHolder= ViewHolder(imageList,name,numberTourist)
            view.setTag(viewHolder)
        }
        else {
            viewHolder = view.getTag() as ViewHolder

        }
        viewHolder.imageList.setImageResource(listRestaurant.get(position).listImage)
        viewHolder.name.setText(listRestaurant.get(position).name)
      //  viewHolder.numberTourist.setText("${listCities.get(position).touristNumber} de touristes par an")
        return view

    }

    private data class ViewHolder(var imageList: ImageView, var name: TextView, var numberTourist: TextView)
}