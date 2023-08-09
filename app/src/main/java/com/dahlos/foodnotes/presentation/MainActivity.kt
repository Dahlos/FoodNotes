package com.dahlos.foodnotes.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dahlos.foodnotes.navigation.NavHostGraph
import com.dahlos.foodnotes.navigation.NavigationBarBottom
import com.dahlos.foodnotes.navigation.Screen
import com.dahlos.foodnotes.presentation.ui.theme.FoodNotesTheme
import com.dahlos.foodnotes.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                ) {
                    NavHostGraph(navController)
                }
            }
        }

    }
}
