package com.bounouamustapha.mata3im.Activities.Model

import java.io.Serializable

/**
 * Created by bounouamustapha on 4/3/18.
 */
data class Plat(
        var listImage: Int = 0,
        var detailImage:MutableList<Int> = mutableListOf<Int>(),
        var name: String = "",
        var description: String = "",
        var jaime: Boolean = false,
        var nbJaime: Int = 0,
        var type: String ="",
        var prix: Double = 0.0,
        var vegetarien :Boolean=false,
        var diabetique:Boolean=false,
        var dujour :Boolean=false,
        var binaire:Boolean=false,
        var cart :Boolean=false,
        var bookmark :Boolean=false
        ) :Serializable{
}