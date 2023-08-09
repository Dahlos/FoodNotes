package com.dahlos.foodnotes.presentation.ui.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dahlos.foodnotes.presentation.viewmodel.MainViewModel
import com.dahlos.foodnotes.utils.ResultViewState
import org.koin.androidx.compose.getViewModel

@Composable
internal fun MainScreen() {
    val viewModel: MainViewModel = getViewModel()
    InitFoodCategoriesObserver(viewModel)
    Column {
        Text(text = "Food Notes", style = MaterialTheme.typography.headlineLarge)
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
            Log.d("MainScreen", state.data.toString())
        }

        ResultViewState.Empty -> Log.d("MainScreen", "Empty")
        is ResultViewState.Error -> Log.d("MainScreen", "Error")
    }
}
