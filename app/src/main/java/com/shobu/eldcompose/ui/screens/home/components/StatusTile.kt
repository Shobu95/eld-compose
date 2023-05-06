package com.shobu.eldcompose.ui.screens.home.components

import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.annotation.DrawableRes
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobu.eldcompose.R
import com.shobu.eldcompose.ui.screens.shared.ShowToastAlert


@Preview
@Composable
fun StatusTilePrev() {
    StatusTile(
        backgroundColor = Color(0xFFFFB74D),
        statusIcon = R.drawable.battery,
        headingText = "88%",
        messageText = "Battery Status"
    )
}

@Composable
fun StatusTile(
    backgroundColor: Color,
    @DrawableRes statusIcon: Int,
    headingText: String,
    messageText: String
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(14.dp)
            )
            .clickable {
                ShowToastAlert(
                    context,
                    "Feature not available, please install device in a vehicle.",

                )
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        val statusIcon = painterResource(id = statusIcon)
        Image(
            painter = statusIcon,
            contentDescription = "status icon",
            modifier = Modifier
                .size(width = 60.dp, height = 85.dp)
                .padding(top = 20.dp, bottom = 20.dp)
        )

        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = headingText,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.roboto))
                )
            )

            Text(
                modifier = Modifier.width(100.dp),
                text = messageText,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}