package com.dahlos.foodnotes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlos.foodnotes.data.datasource.local.dao.FoodCategoryDao
import com.dahlos.foodnotes.data.datasource.local.entities.FoodCategoryEntity
import com.dahlos.foodnotes.data.datasource.repository.FoodCategoriesRepository
import com.dahlos.foodnotes.utils.ResultViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class MainViewModel(private val foodCategoriesRepository: FoodCategoriesRepository) : ViewModel() {

    private val _initFoodCategoriesState = MutableStateFlow<ResultViewState>(ResultViewState.Initial)
    val initFoodCategoriesState = _initFoodCategoriesState.asStateFlow()

    fun initFoodCategories() {
        viewModelScope.launch() {
            _initFoodCategoriesState.emit(foodCategoriesRepository.initFoodCategories())
        }
    }
}