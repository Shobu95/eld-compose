package com.shobu.eldcompose.ui.screens.profile

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shobu.eldcompose.R
import com.shobu.eldcompose.ui.screens.profile.components.CarDetailsItem
import com.shobu.eldcompose.ui.screens.profile.components.PersonalDetails

@Preview
@Composable
fun ProfileScreenPrev() {
    ProfileScreen(R.string.title_profile)
}


@Composable
fun ProfileScreen(@StringRes title: Int) {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        
        PersonalDetails()
        
        Spacer(modifier = Modifier.height(40.dp))
        
        CarDetailsItem(
            R.drawable.car_icon,
            "Honda Civic Turbo",
            "Vehicle"
        )

        CarDetailsItem(
            R.drawable.plate,
            "ASD-490",
            "License Plate"
        )

        CarDetailsItem(
            R.drawable.engine,
            "ZO53361",
            "Engine No."
        )

    }
}