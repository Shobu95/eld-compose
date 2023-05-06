package com.shobu.eldcompose.ui.screens.tutorial_slider

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.shobu.eldcompose.ui.screens.main.MainActivity
import com.shobu.eldcompose.ui.screens.tutorial_slider.components.ImageSliderWithText
import com.shobu.eldcompose.ui.screens.tutorial_slider.components.PagerDotsIndicator
import com.shobu.eldcompose.ui.screens.tutorial_slider.components.TutorialSliderFooter
import com.shobu.eldcompose.ui.theme.ELDComposeTheme
import kotlinx.coroutines.launch

@ExperimentalPagerApi
class TutorialSlider : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ELDComposeTheme {
                TutorialSliderBody { navigateToMain(
                    this
                ) }
            }
        }
    }

    private fun navigateToMain(context: Context) {
        lifecycleScope.launch {
            val intent = Intent(
                this@TutorialSlider,
                MainActivity::class.java
            )
            context.startActivity(intent)
            finish()
        }
    }

}

@ExperimentalPagerApi
@Preview
@Composable
fun TutorialSliderBodyPrev() {
    TutorialSliderBody { }
}

@ExperimentalPagerApi
@Composable
fun TutorialSliderBody(navigateToMain: () -> Unit) {
    val pagerState = rememberPagerState()


    Box(Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.padding(bottom = 20.dp),
            ) {

            ImageSliderWithText(
                pagerState = pagerState,
                modifier = Modifier.weight(1f)
            )
            
            Spacer(modifier = Modifier.height(150.dp))

            TutorialSliderFooter(pagerState, navigateToMain)
        }

        PagerDotsIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
        )
    }
}

