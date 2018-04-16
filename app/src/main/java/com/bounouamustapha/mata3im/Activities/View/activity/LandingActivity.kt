package com.bounouamustapha.mata3im.Activities.View.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bounouamustapha.mata3im.R
import com.bounouamustapha.mata3im.R.id.start
import kotlinx.android.synthetic.main.activity_landing.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop


class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        startButton.setOnClickListener({view ->
            startActivity(intentFor<ListRestaurantActivity>("id" to 5).singleTop())
        })
    }
}
