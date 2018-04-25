package com.bounouamustapha.mata3im.Activities.Controller

import com.bounouamustapha.mata3im.Activities.Model.Plat
import com.bounouamustapha.mata3im.Activities.Model.PlatUnaire
import com.bounouamustapha.mata3im.Activities.Model.Restaurant
import com.bounouamustapha.mata3im.R

/**
 * Created by bounouamustapha on 4/1/18.
 */
class DataController {

    fun getRestaurants():List<Restaurant> {
        var list = mutableListOf<Restaurant>()
        var list2 = mutableListOf<Plat>()
        var list3 = mutableListOf<Int>()
        list3.add(R.drawable.barcelone_detail)
        list3.add(R.drawable.paris_list)
        list3.add(R.drawable.bar)

        var plat= Plat(true,true

        )
        for (i in 0..5) list2.add(plat)

        var restaurant = Restaurant(
                R.drawable.paris_list,
                list3,
                "rachid",
                "bouraoui","07789303938" ,"a@@.com",
                "hfdjhfdjhfjdhfjdhfjhdfjhdjhfdhfjhdjfhjdhfjdhfjhdj"+
                "hfdjhfdjhfjdhfjdhfjhdfjhdjhfdhfjhdjfhjdhfjdhfjhdj" +
                "hfdjhfdjhfjdhfjdhfjhdfjhdjhfdhfjhdjfhjdhfjdhfjhdj" +
                "hfdjhfdjhfjdhfjdhfjhdfjhdjhfdhfjhdjfhjdhfjdhfjhdj"
                ,22,32,44,false,list2,"https://web.facebook.com/adel.bounoua.3",
                "https://web.facebook.com/adel.bounoua.3","https://web.facebook.com/adel.bounoua.3"
        )
        var restaurant2 = Restaurant(
                R.drawable.paris_list,
                list3,
                "ramdan",
                "smar","07789303938" ,"a@@.com",
                "hfdjhfdjhfjdhfjdhfjhdfjhdjhfdhfjhdjfhjdhfjdhfjhdj"+
                        "hfdjhfdjhfjdhfjdhfjhdfjhdjhfdhfjhdjfhjdhfjdhfjhdj" +
                        "hfdjhfdjhfjdhfjdhfjhdfjhdjhfdhfjhdjfhjdhfjdhfjhdj" +
                        "hfdjhfdjhfjdhfjdhfjhdfjhdjhfdhfjhdjfhjdhfjdhfjhdj"
                ,22,32,44,false,list2,"https://web.facebook.com/adel.bounoua.3",
                "https://web.facebook.com/adel.bounoua.3","https://web.facebook.com/adel.bounoua.3",
                36.7197144,3.1450452
        )


        for (i in 0..5) list.add(restaurant)
        for (i in 0..5) list.add(restaurant2)
        return  list
    }
}