package com.dahlos.foodnotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dahlos.foodnotes.presentation.ui.view.MainScreen
import com.dahlos.foodnotes.presentation.ui.view.diarygroup.DiaryGroupScreen

@Composable
internal fun NavHostGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController,
        modifier = modifier,
        startDestination = Screen.MainScreen.route,
    ) {
        composable(Screen.MainScreen.route) { MainScreen() }
        composable(Screen.DiaryGroupScreen.route) { DiaryGroupScreen(navController) }
    }
}