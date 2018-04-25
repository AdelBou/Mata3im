package com.bounouamustapha.mata3im.Activities.View.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.bounouamustapha.mata3im.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.CameraUpdate
import kotlinx.android.synthetic.main.app_bar_restaurants.*
import org.jetbrains.anko.toast
import android.view.MenuInflater
import android.view.MenuItem
import com.bounouamustapha.mata3im.Activities.Model.Restaurant


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var resto :Restaurant;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        resto = intent.getSerializableExtra("restaurant") as Restaurant
        getSupportActionBar()!!.setTitle(resto.name+", "+resto.adresse)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val position = LatLng(resto.x, resto.y)
        mMap.addMarker(MarkerOptions().position(position).title(resto.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(position))
        val center = CameraUpdateFactory.newLatLng(position)
        val zoom = CameraUpdateFactory.newLatLngZoom(position, 3f)
        googleMap.animateCamera(center)
        googleMap.animateCamera(zoom)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_map, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Change the map type based on the user's selection.
        when (item.getItemId()) {
            R.id.normal_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                return true
            }
            R.id.hybrid_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                return true
            }
            R.id.satellite_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                return true
            }
            R.id.terrain_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
