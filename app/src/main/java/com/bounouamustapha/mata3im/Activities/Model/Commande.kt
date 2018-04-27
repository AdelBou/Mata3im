package com.bounouamustapha.mata3im.Activities.Model

import java.io.Serializable

/**
 * Created by bounouamustapha on 4/16/18.
 */
data  class Commande(var plat: Plat = Plat(),
                     var  nbPlats:Int=0,
                     var price :Double=0.0,
                     var restaurant:Restaurant= Restaurant(),
                     var valide:Boolean=false) :Serializable
{
}