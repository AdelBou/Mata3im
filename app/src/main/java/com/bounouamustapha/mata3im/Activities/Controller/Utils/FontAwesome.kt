package com.bounouamustapha.mata3im.Activities.Controller.Utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView



/**
 * Created by bounouamustapha on 4/22/18.
 */
class FontAwesome : TextView {


    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    private fun init() {

        //Font name should not contain "/".
        val tf = Typeface.createFromAsset(context.assets,
                "fontawesome.ttf")
        typeface = tf
    }

}