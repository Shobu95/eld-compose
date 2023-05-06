package com.shobu.eldcompose.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun ProfileSectionPrev() {
    ProfileSection({})
}

@Composable
fun ProfileSection(onImageClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Column() {
            Text(
                text = "Welcome, User",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto))
                )
            )

            Text(
                text = "Honda Civic Turbo",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight.Bold
                )
            )
        }

        val profilePic = painterResource(id = R.drawable.profile_pic)
        Image(
            painter = profilePic,
            contentDescription = "profile pic",
            Modifier.size(50.dp).clickable { onImageClick() }
        )
    }
}