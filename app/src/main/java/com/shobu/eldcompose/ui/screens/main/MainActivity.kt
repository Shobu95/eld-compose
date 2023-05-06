package com.shobu.eldcompose.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.shobu.eldcompose.ui.screens.main.components.NavigationGraph
import com.shobu.eldcompose.ui.theme.ELDComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ELDComposeTheme {
                MainScreen()
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPrev() {
    MainScreen()
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold() { innerPadding ->
        Box(modifier = androidx.compose.ui.Modifier.padding(innerPadding)) {
            NavigationGraph(navController = navController)
        }
    }

}


