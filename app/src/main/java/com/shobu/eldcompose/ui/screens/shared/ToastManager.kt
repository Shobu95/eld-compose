package com.shobu.eldcompose.ui.screens.shared

import android.content.Context
import android.widget.Toast


fun ShowToastAlert(
    context: Context,
    message: String,
    length: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(
        context,
        message,
        length
    ).show()
}