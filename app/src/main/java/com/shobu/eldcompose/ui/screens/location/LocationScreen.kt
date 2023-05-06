@file:Suppress("SAFE_CALL_WILL_CHANGE_NULLABILITY", "UNNECESSARY_SAFE_CALL")

package com.shobu.eldcompose.ui.screens.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.shobu.eldcompose.R

@Preview
@Composable
fun LocationScreenPrev() {
    LocationScreen(R.string.title_location)
}

private var locationCallback: LocationCallback? = null
var fusedLocationClient: FusedLocationProviderClient? = null
private var locationRequired = false

@Composable
fun LocationScreen(@StringRes title: Int) {
    val context = LocalContext.current

    var cl by remember {
        mutableStateOf(LocationDetails(0.toDouble(), 0.toDouble()))
    }

    val location by
    remember { mutableStateOf(LatLng(cl.latitude, cl.longitude)) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)


        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                for (lo in p0.locations) {
                    cl = LocationDetails(lo.latitude, lo.longitude)
                    Log.v("location_callback", cl.toString())

                }
            }
        }


        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(LatLng(cl.latitude, cl.longitude), 15f)
        }
        val uiSettings = remember {
            MapUiSettings(myLocationButtonEnabled = true)
        }
        val properties by remember {
            mutableStateOf(MapProperties(isMyLocationEnabled = true))
        }


        startLocationUpdates()

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = CameraPositionState(
                position = CameraPosition.fromLatLngZoom(LatLng(cl.latitude, cl.longitude), 15f)
            ),
            properties = properties,
            uiSettings = uiSettings
        ) {
            Marker(
                state = MarkerState(
                    position = LatLng(cl.latitude, cl.longitude)
                ),
                title = "Singapore",
                snippet = "Marker in Singapore",
                icon = bitmapDescriptorFromVector(context, R.drawable.car_marker)
            )
        }
    }

}

fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {

    // retrieve the actual drawable
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    // draw it onto the bitmap
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}

@SuppressLint("MissingPermission")
fun startLocationUpdates() {
    locationCallback?.let {
        val locationRequest = LocationRequest.create().apply {
            interval = 1000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        fusedLocationClient?.requestLocationUpdates(
            locationRequest,
            it,
            Looper.getMainLooper()
        )
    }
}

data class LocationDetails(val latitude: Double, val longitude: Double)