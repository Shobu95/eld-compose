package com.shobu.eldcompose.ui.screens.home

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shobu.eldcompose.R
import com.shobu.eldcompose.ui.screens.home.components.CarImage
import com.shobu.eldcompose.ui.screens.home.components.LocationTile
import com.shobu.eldcompose.ui.screens.home.components.ProfileSection
import com.shobu.eldcompose.ui.screens.home.components.StatusTile
import com.shobu.eldcompose.ui.screens.main.components.NavigationItem
import com.shobu.eldcompose.ui.screens.shared.ProgressDialog
import com.shobu.eldcompose.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun HomeScreenPrev() {
    val navController = rememberNavController()
    HomeScreen(R.string.title_home, navController)
}


@Composable
fun HomeScreen(
    @StringRes title: Int,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        ProfileSection { navController.navigate(NavigationItem.Profile.route) }

        Spacer(modifier = Modifier.height(10.dp))
        CarImage()

        Spacer(modifier = Modifier.height(10.dp))

        val context = LocalContext.current
        var showDialog by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()

        val permissions = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        val launcherMultiplePermissions = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissionsMap ->
            val areGranted = permissionsMap.values.reduce { acc, next -> acc && next }
            if (areGranted) {
                showDialog = true
                scope.launch {
                    delay(3500)
                    showDialog = false
                    navController.navigate(NavigationItem.Location.route)
                }
            } else {
                Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }



        LocationTile() {
            if (permissions.all {
                    ContextCompat.checkSelfPermission(
                        context,
                        it
                    ) == PackageManager.PERMISSION_GRANTED
                }) {
                showDialog = true
                scope.launch {
                    delay(3500)
                    showDialog = false
                    navController.navigate(NavigationItem.Location.route)
                }
            } else {
                launcherMultiplePermissions.launch(permissions)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(modifier = Modifier.weight(1f)) {
                StatusTile(
                    backgroundColor = CarOrange,
                    statusIcon = R.drawable.battery,
                    headingText = "88%",
                    messageText = "Battery Status"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier.weight(1f)) {
                StatusTile(
                    backgroundColor = FuelStatusBg,
                    statusIcon = R.drawable.fuel_pic,
                    headingText = "30.5 Ltr",
                    messageText = "Fuel remaining 200 km mileage"
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(modifier = Modifier.weight(1f)) {
                StatusTile(
                    backgroundColor = TyrePressureBg,
                    statusIcon = R.drawable.tyre_pressure,
                    headingText = "35 psi",
                    messageText = "Tyre pressure"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier.weight(1f)) {
                StatusTile(
                    backgroundColor = LocationTileBg,
                    statusIcon = R.drawable.engine,
                    headingText = "87 ‘C",
                    messageText = "Engine Temperature"
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(modifier = Modifier.weight(1f)) {
                StatusTile(
                    backgroundColor = CarCameraBg,
                    statusIcon = R.drawable.car_camera,
                    headingText = "Car\nCamera",
                    messageText = ""
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier.weight(1f)) {
                StatusTile(
                    backgroundColor = CarHealthBg,
                    statusIcon = R.drawable.car_health,
                    headingText = "Health Monitoring",
                    messageText = ""
                )
            }
        }

        if (showDialog) {
            ProgressDialog(showDialog = showDialog)
        }


    }
}