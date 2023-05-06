package com.shobu.eldcompose.ui.screens.profile.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
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
import com.shobu.eldcompose.ui.theme.DividerBg
import com.shobu.eldcompose.ui.theme.TextLight


@Preview
@Composable
fun CarDetailsItemPrev() {
    CarDetailsItem(
        R.drawable.engine,
        "Honda Civic Turbo",
        "Vehicle"
    )
}


@Composable
fun CarDetailsItem(
    @DrawableRes detailIcon: Int,
    detailName: String,
    detailLabel: String
) {
    Column(
        modifier =
        Modifier
            .padding(start = 30.dp, end = 30.dp, bottom = 20.dp)
            .background(color = Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            val detailPic = painterResource(id = detailIcon)
            Icon(
                painter = detailPic,
                contentDescription = "",
                tint = TextLight,
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp)
            )

            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = detailName,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto))
                    )
                )

                Text(
                    text = detailLabel,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = TextLight,
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }

        Divider(color = DividerBg, thickness = 1.dp, modifier = Modifier.padding(top = 10.dp))
    }
}