package com.shobu.eldcompose.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobu.eldcompose.R
import com.shobu.eldcompose.ui.theme.LocationTileBg

@Preview
@Composable
fun LocationTilePrev() {
    LocationTile({})
}

@Composable
fun LocationTile(onLocationClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = LocationTileBg,
                shape = RoundedCornerShape(14.dp)
            )
            .clickable { onLocationClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Column(modifier = Modifier.padding(start = 36.dp)) {
            Text(
                text = "Location",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.roboto))
                )
            )

            Text(
                text = "Track your vehicle’s current location.",
                modifier = Modifier.width(150.dp),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight.Normal
                )
            )
        }

        val locationPic = painterResource(id = R.drawable.location_pic)
        Image(
            painter = locationPic,
            contentDescription = "location pic",
            Modifier
                .size(width = 180.dp, height = 120.dp)
                .padding(end = 30.dp)
        )
    }
}