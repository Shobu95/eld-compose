package com.shobu.eldcompose.ui.screens.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.shobu.eldcompose.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.shobu.eldcompose.ui.screens.tutorial_slider.TutorialSlider
import com.shobu.eldcompose.ui.theme.ELDComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ELDComposeTheme {
                SplashScreenBody()
            }
            navigateToHome(LocalContext.current)
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    private fun navigateToHome(context: Context) {
        lifecycleScope.launch {
            delay(3000)
            val intent = Intent(
                this@SplashScreen,
                TutorialSlider::class.java
            )
            context.startActivity(intent)
            finish()
        }
    }
}

@Preview
@Composable
fun SplashScreenBodyPrev() {
    SplashScreenBody()
}

@Composable
fun SplashScreenBody() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val splashLogo = painterResource(id = R.drawable.splash_icon)
                Image(
                    painter = splashLogo,
                    contentDescription = "splash logo",
                    Modifier.size(200.dp)
                )

                Text(
                    text = "Electronic Logging Device",
                    Modifier.padding(bottom = 180.dp, top = 20.dp),
                    style = TextStyle(
                        color = MaterialTheme.colors.onSurface,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

            }

            Text(
                text = "LOADING...",
                Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 80.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.primary,
                    letterSpacing = 1.sp,
                    fontSize = 12.sp
                )
            )
        }
    }
}

