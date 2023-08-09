package com.dahlos.foodnotes.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dahlos.foodnotes.R

internal sealed class Screen(val route: String, @StringRes val stringId: Int, @DrawableRes val resourceId: Int) {
    object MainScreen : Screen("main_screen", R.string.main_screen_name,R.drawable.ic_launcher_foreground)
    object AddMealScreen : Screen("add_meal_screen", R.string.add_meal_screen_name, R.drawable.ic_launcher_foreground)
    object DiaryGroupScreen : Screen("diary_group_screen", R.string.diary_group_Screen, R.drawable.ic_launcher_foreground)
}
