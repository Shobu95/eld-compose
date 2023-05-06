package com.shobu.eldcompose.ui.screens.tutorial_slider.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobu.eldcompose.R
import com.shobu.eldcompose.ui.screens.tutorial_slider.TutorialSliderItem

@Preview
@Composable
private fun TutorialSliderPageUiPrev() {
    TutorialSliderPageUi(page = TutorialSliderItem.pages[0])
}

@Composable
fun TutorialSliderPageUi(
    page: TutorialSliderItem,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(page.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.BottomCenter

        )

        Spacer(modifier = Modifier.height(38.dp))

        Text(
            text = stringResource(id = page.title),
            fontSize = 30.sp,
            fontFamily = FontFamily(
                Font(R.font.roboto)
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = stringResource(id = page.description),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = FontFamily(
                Font(R.font.roboto)
            )
        )
    }




}