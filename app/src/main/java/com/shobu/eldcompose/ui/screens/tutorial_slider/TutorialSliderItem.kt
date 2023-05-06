package com.shobu.eldcompose.ui.screens.tutorial_slider

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.shobu.eldcompose.R

data class TutorialSliderItem(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
) {
    companion object {
        val pages = listOf(
            TutorialSliderItem(
                R.drawable.tutorial_img_1,
                R.string.vehicle_tracking,
                R.string.tutorial_text_1,
            ),
            TutorialSliderItem(
                R.drawable.tutorial_img_2,
                R.string.health_monitoring,
                R.string.tutorial_text_2,
            ),
            TutorialSliderItem(
                R.drawable.tutorial_img_3,
                R.string.fuel_millage,
                R.string.tutorial_text_3,
            )
        )
    }

}
