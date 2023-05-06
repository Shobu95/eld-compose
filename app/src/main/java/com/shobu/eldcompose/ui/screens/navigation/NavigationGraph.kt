package com.shobu.eldcompose.ui.screens.main.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shobu.eldcompose.ui.screens.home.HomeScreen
import com.shobu.eldcompose.ui.screens.location.LocationScreen
import com.shobu.eldcompose.ui.screens.profile.ProfileScreen
import com.shobu.eldcompose.ui.screens.register_device.RegisterDeviceScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavigationItem.Register.route) {

        composable(NavigationItem.Register.route) {
            RegisterDeviceScreen(
                title = NavigationItem.Register.title,
                navController = navController
            )
        }

        composable(NavigationItem.Home.route) {
            HomeScreen(
                title = NavigationItem.Home.title,
                navController = navController
            )
        }

        composable(NavigationItem.Location.route) {
            LocationScreen(
                NavigationItem.Location.title,
            )
        }

        composable(NavigationItem.Profile.route) {
            ProfileScreen(
                title = NavigationItem.Profile.title,
            )
        }
    }
}