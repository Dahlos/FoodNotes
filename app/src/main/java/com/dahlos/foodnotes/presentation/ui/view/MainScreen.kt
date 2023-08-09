package com.dahlos.foodnotes.presentation.ui.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dahlos.foodnotes.presentation.viewmodel.MainViewModel
import com.dahlos.foodnotes.utils.ResultViewState
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun MainScreen() {
    val viewModel: MainViewModel = getViewModel()
    InitFoodCategoriesObserver(viewModel)
    FoodCategoriesObserver(viewModel)
}

@Composable
private fun FoodCategoriesObserver(viewModel: MainViewModel) {
    when (val state = viewModel.getAllFoodCategoriesState.collectAsStateWithLifecycle().value) {
        is ResultViewState.Error -> Log.d("FoodCategoriesObserver", "Error")
        ResultViewState.Loading -> Log.d("FoodCategoriesObserver", "Loading")
        is ResultViewState.Success -> {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.data) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = it.category)
                        }
                    }
                }
            }
        }

        else -> Unit
    }
}

@Composable
private fun InitFoodCategoriesObserver(viewModel: MainViewModel) {
    when (val state = viewModel.initFoodCategoriesState.collectAsStateWithLifecycle().value) {
        ResultViewState.Initial -> {
            Log.d("MainScreen", "Initial")
            viewModel.initFoodCategories()
        }

        ResultViewState.Loading -> Log.d("MainScreen", "Loading")
        is ResultViewState.Success -> {
            Log.d("MainScreen", "Success")
            Log.d("MainScreen", state.data)
            viewModel.getAllFoodCategories()
        }

        is ResultViewState.Error -> Log.d("MainScreen", "Error")
    }
}
