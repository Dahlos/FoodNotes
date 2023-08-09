package com.dahlos.foodnotes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dahlos.foodnotes.navigation.NavHostGraph
import com.dahlos.foodnotes.navigation.NavigationBarBottom
import com.dahlos.foodnotes.navigation.Screen
import com.dahlos.foodnotes.presentation.ui.theme.FoodNotesTheme


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val items = listOf(
            Screen.MainScreen,
            Screen.DiaryGroupScreen,
        )

        setContent {
            val navController = rememberNavController()
            FoodNotesTheme {
                Scaffold(
                    bottomBar = { NavigationBarBottom(items, navController) },
                    modifier = Modifier.fillMaxSize(),
                ) { padding ->
                    NavHostGraph(navController, Modifier.padding(padding))
                }
            }
        }
    }
}
