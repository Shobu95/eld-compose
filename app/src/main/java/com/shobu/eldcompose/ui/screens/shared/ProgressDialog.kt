package com.shobu.eldcompose.ui.screens.shared

import android.app.Dialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Preview
@Composable
fun ProgressDialogPrev() {
    ProgressDialog(true)
}

@Composable
fun ProgressDialog(showDialog: Boolean) {
    var _showDialog = true
    Dialog(
        onDismissRequest = { _showDialog = false },
        DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(120.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
        ) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(10.dp))
            Text("Please wait...")
        }
    }
}