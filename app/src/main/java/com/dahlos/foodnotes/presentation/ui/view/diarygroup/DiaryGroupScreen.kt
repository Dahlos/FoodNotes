package com.dahlos.foodnotes.presentation.ui.view.diarygroup

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
internal fun DiaryGroupScreen(navController: NavController) {
    Column {
        Text(text = "DiaryGroupScreen", style = MaterialTheme.typography.headlineLarge)
    }
}