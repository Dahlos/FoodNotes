package com.dahlos.foodnotes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlos.foodnotes.data.datasource.repository.FoodCategoriesRepository
import com.dahlos.foodnotes.presentation.ui.models.FoodCategoryModel
import com.dahlos.foodnotes.utils.ResultViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class MainViewModel(private val foodCategoriesRepository: FoodCategoriesRepository) : ViewModel() {

    private val _initFoodCategoriesState = MutableStateFlow<ResultViewState<String>>(ResultViewState.Initial)
    val initFoodCategoriesState = _initFoodCategoriesState.asStateFlow()

    private val _getAllFoodCategoriesState =
        MutableStateFlow<ResultViewState<List<FoodCategoryModel>>>(ResultViewState.Initial)
    val getAllFoodCategoriesState = _getAllFoodCategoriesState.asStateFlow()

    fun initFoodCategories() {
        _initFoodCategoriesState.tryEmit(ResultViewState.Loading)
        viewModelScope.launch() {
            _initFoodCategoriesState.emit(foodCategoriesRepository.initFoodCategories())
        }
    }

    fun getAllFoodCategories() {
        _getAllFoodCategoriesState.tryEmit(ResultViewState.Loading)
        viewModelScope.launch() {
            _getAllFoodCategoriesState.emit(foodCategoriesRepository.getAllFoodCategories())
        }
    }

}