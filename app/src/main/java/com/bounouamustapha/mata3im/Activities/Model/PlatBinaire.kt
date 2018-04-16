package com.bounouamustapha.mata3im.Activities.Model

/**
 * Created by bounouamustapha on 4/16/18.
 */
class PlatBinaire (var plat1 :Plat,var plat2:Plat)
    : Plat((plat1.typeVegetarien&&plat2.typeVegetarien),
        (plat1.typeDiabetique && plat2.typeDiabetique) ){
}