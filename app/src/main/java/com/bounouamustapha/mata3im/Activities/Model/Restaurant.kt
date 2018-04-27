package com.bounouamustapha.mata3im.Activities.Model

import java.io.Serializable

/**
 * Created by bounouamustapha on 3/31/18.
 */
data class Restaurant  (var listImage:Int=0,
                        var detailImage:MutableList<Int> = mutableListOf<Int>(),
                        var name:String="",
                        var adresse:String="",
                        var tel:String="",
                        var mail:String="",
                        var description:String="",
                        var nbJaime:Int =0,
                        var nbPlace:Int=0,
                        var nbPlat:Int=0,
                        var jaime:Boolean=false,
                        var listPlats:MutableList<Plat> = mutableListOf<Plat>(),
                        var facebook :String="",
                        var instagram: String="",
                        var twitter:String="",
                        var x :Double= 0.0,
                        var y :Double=0.0,
                        var listBinaire:MutableList<PlatBinaire> = mutableListOf<PlatBinaire>()
                        ):Serializable
{
}