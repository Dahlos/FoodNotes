package com.dahlos.foodnotes.presentation.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun MainScreen() {
   Column {
       Text(text = "Food Notes", style = MaterialTheme.typography.headlineLarge)
   }
}

//        topBar = {
//            TopAppBar(
//                title = { Text(text = "Food Notes") },
//                colors = TopAppBarDefaults.smallTopAppBarColors(
//                    containerColor = lightColorScheme().primary,
//                    titleContentColor = Color.White,
//                )
//            )
//        }