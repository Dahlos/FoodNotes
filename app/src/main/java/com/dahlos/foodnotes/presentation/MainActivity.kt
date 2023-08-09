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
            initRoom()

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

    @Composable
    private fun initRoom() {
        val viewModel = getViewModel<MainViewModel>()
        viewModel.insertFoodCategory()
//        LaunchedEffect(Unit) {
//            val database  = get<AppDatabase>()
//            lifecycleScope.launch {
//                database.run {
//                    foodCategoryDao().insert(FoodCategoryEntity(1, "Cereales"))
//                    foodCategoryDao().insert(FoodCategoryEntity(2, "Vegetales libre consumo"))
//                    foodCategoryDao().insert(FoodCategoryEntity(3, "Vegetales consumo general"))
//                    foodCategoryDao().insert(FoodCategoryEntity(4, "Frutas"))
//                    foodCategoryDao().insert(FoodCategoryEntity(5, "Lácteos"))
//                    foodCategoryDao().insert(FoodCategoryEntity(6, "Carnes bajas en grasas"))
//                    foodCategoryDao().insert(FoodCategoryEntity(7, "Alimentos ricos en lípidos"))
//                    foodCategoryDao().insert(FoodCategoryEntity(8, "Aceites y grasas"))
//                }
//            }
//        }
//        val database = AppDatabase.getInstance(this)
//        val database : AppDatabase by inject()


    }
}
