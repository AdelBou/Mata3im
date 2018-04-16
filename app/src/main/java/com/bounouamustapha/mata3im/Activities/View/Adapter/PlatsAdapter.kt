package com.bounouamustapha.mata3im.Activities.View.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bounouamustapha.mata3im.Activities.Model.PlatUnaire
import com.bounouamustapha.mata3im.R

/**
 * Created by bounouamustapha on 4/4/18.
 */
class PlatsAdapter (_ctx: Context, listPlatUnaires:List<PlatUnaire>): BaseAdapter() {
    var ctx = _ctx
    val listPlats = listPlatUnaires


    override fun getItem(p0: Int) = listPlats.get(p0)

    override fun getItemId(p0: Int) = listPlats.get(p0).hashCode().toLong()

    override fun getCount()= listPlats.size

    override fun getView(position: Int, p0: View?, parent: ViewGroup?): View {
        var view = p0
        var viewHolder: ViewHolder
        if(view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.restaurant_item,parent,false)
            val imageList = view?.findViewById<ImageView>(R.id.listimage) as ImageView
            val name = view?.findViewById<TextView>(R.id.name) as TextView
            viewHolder= ViewHolder(imageList,name)
            view.setTag(viewHolder)
        }
        else {
            viewHolder = view.getTag() as ViewHolder

        }
        viewHolder.imageList.setImageResource(listPlats.get(position).listImage)
        viewHolder.name.setText(listPlats.get(position).name)
        return view
    }

    private data class ViewHolder(var imageList: ImageView, var name: TextView)
}