package com.shobu.eldcompose.ui.screens.main.components

import androidx.annotation.StringRes
import com.shobu.eldcompose.R

sealed class NavigationItem(
    @StringRes var title: Int,
    var route: String,
) {

    object Register :
        NavigationItem(
            R.string.title_register,
            "register"
        )

    object Home :
        NavigationItem(
            R.string.title_home,
            "home"
        )

    object Location :
        NavigationItem(
            R.string.title_location,
            "location"
        )

    object Profile :
        NavigationItem(
            R.string.title_profile,
            "profile"
        )

}