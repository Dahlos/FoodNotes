package com.dahlos.foodnotes.data.datasource.repository

import com.dahlos.foodnotes.presentation.ui.models.FoodCategoryModel
import com.dahlos.foodnotes.utils.ResultViewState

internal interface FoodCategoriesRepository {
    suspend fun initFoodCategories(): ResultViewState<String>
    suspend fun getAllFoodCategories(): ResultViewState<List<FoodCategoryModel>>
}