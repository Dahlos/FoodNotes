package com.dahlos.foodnotes.data.datasource.repository

import com.dahlos.foodnotes.utils.ResultViewState
import kotlinx.coroutines.flow.Flow

internal interface FoodCategoriesRepository {
    suspend fun initFoodCategories(): ResultViewState
}