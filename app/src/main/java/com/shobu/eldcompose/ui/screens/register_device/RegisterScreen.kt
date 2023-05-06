package com.shobu.eldcompose.ui.screens.register_device

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shobu.eldcompose.R
import com.shobu.eldcompose.ui.screens.main.MainActivity
import com.shobu.eldcompose.ui.screens.main.components.NavigationItem
import com.shobu.eldcompose.ui.screens.shared.BorderedTextField
import com.shobu.eldcompose.ui.screens.shared.PrimaryButton
import com.shobu.eldcompose.ui.screens.shared.ProgressDialog
import com.shobu.eldcompose.ui.screens.shared.ShowToastAlert
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun RegisterScreenPrev() {
    val navController = rememberNavController()
    RegisterDeviceScreen(R.string.title_register, navController)
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterDeviceScreen(@StringRes title: Int, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        var textFieldValue = remember { mutableStateOf("") }
        var showDialog by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()
        val context = LocalContext.current

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = "Please enter your tracking device’s ID: ",
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            BorderedTextField(textFieldValue)
            Spacer(modifier = Modifier.height(50.dp))
            PrimaryButton(buttonText = R.string.login) {
                if (textFieldValue.value.isNullOrEmpty()) {
                    scope.launch {
                        ShowToastAlert(context, "Please enter device ID")
                    }
                } else if (textFieldValue.value.uppercase() != "TRACK0001") {
                    ShowToastAlert(context, "Please enter a valid device ID")
                } else {
                    showDialog = true
                    scope.launch {
                        delay(3500)
                        showDialog = false
                        navController.navigate(NavigationItem.Home.route)
                    }
                }
            }
        }

        if (showDialog) {
            ProgressDialog(showDialog = showDialog)
        }
    }
}