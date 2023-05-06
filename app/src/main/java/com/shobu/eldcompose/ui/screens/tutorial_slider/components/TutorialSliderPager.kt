package com.shobu.eldcompose.ui.screens.tutorial_slider.components

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.shobu.eldcompose.ui.screens.tutorial_slider.TutorialSliderItem

@ExperimentalPagerApi
@Composable
fun ImageSliderWithText(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        count = TutorialSliderItem.pages.size,
        state = pagerState,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier.fillMaxWidth()
    ) { page ->
        TutorialSliderPageUi(page = TutorialSliderItem.pages[page])
    }
}

@ExperimentalPagerApi
@Composable
fun PagerDotsIndicator(
    pagerState: PagerState,
    modifier: Modifier
) {
    HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = modifier.padding(20.dp),
        activeColor = MaterialTheme.colors.primary,
        inactiveColor = Color.Gray,
        pageCount = TutorialSliderItem.pages.size
    )
}