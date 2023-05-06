package com.shobu.eldcompose.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shobu.eldcompose.R

@Preview
@Composable
fun CarImagePrev() {
    CarImage()
}

@Composable
fun CarImage() {
    val carPic = painterResource(id = R.drawable.car_pic)
    Image(
        painter = carPic,
        contentDescription = "car pic",
        Modifier.fillMaxWidth().height(180.dp)
    )
}

