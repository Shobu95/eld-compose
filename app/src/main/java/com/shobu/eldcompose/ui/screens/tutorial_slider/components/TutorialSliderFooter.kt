package com.shobu.eldcompose.ui.screens.tutorial_slider.components

import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.shobu.eldcompose.R
import com.shobu.eldcompose.ui.screens.shared.PrimaryButton
import com.shobu.eldcompose.ui.screens.tutorial_slider.TutorialSlider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@ExperimentalPagerApi

@Preview
@Composable
fun TutorialSliderFooterPrev() {
    TutorialSliderFooter(rememberPagerState()) {}
}

@ExperimentalPagerApi
@Composable
fun TutorialSliderFooter(
    pagerState: PagerState,
    goToMain: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    val goToNext = {
        coroutineScope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage + 1, 0F)
        }
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

        @StringRes var buttonText = 0

        buttonText = if (pagerState.currentPage == 2) {
            R.string.get_started
        } else {
            R.string.next
        }

        PrimaryButton(buttonText = buttonText) {
            if (pagerState.currentPage == 2) goToMain() else goToNext()
        }
    }
}
