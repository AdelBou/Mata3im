package com.bounouamustapha.mata3im.Activities.Model

import java.io.Serializable

/**
 * Created by bounouamustapha on 4/26/18.
 */
data class PlatBinaire (var plat1: Plat =Plat()
                   ,var plat2: Plat =Plat()
                   ,var desc: String =""
                   ,var price :Double=0.0
                    ,var cart :Boolean =false
                   ,var bookmark:Boolean=false
) :Serializable{
}