package com.shobu.eldcompose.ui.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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

@Preview
@Composable
fun PersonalDetailsPrev() {
    PersonalDetails()
}

@Composable
fun PersonalDetails() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = Color.White)
    ) {

        Text(
            text = "Profile",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(R.font.roboto),
                ),
                fontWeight = FontWeight.ExtraBold
            )
        )

        Spacer(modifier = Modifier.height(44.dp))

        val profilePic = painterResource(id = R.drawable.profile_pic)
        Image(
            painter = profilePic,
            contentDescription = "profile pic",
            Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Track0001",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(
                    Font(R.font.roboto),
                ),
                fontWeight = FontWeight.SemiBold
            )
        )



    }
}