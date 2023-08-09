package com.dahlos.foodnotes.data.datasource.repository.impl

import com.dahlos.foodnotes.data.datasource.local.dao.FoodCategoryDao
import com.dahlos.foodnotes.data.datasource.local.entities.FoodCategoryEntity
import com.dahlos.foodnotes.data.datasource.repository.FoodCategoriesRepository
import com.dahlos.foodnotes.utils.ResultViewState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

internal class FoodCategoriesRepositoryImpl(
    private val foodCategoryDao: FoodCategoryDao, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : FoodCategoriesRepository {

    companion object {
        private val foodCategories = listOf(
            FoodCategoryEntity(1, "Cereales"),
            FoodCategoryEntity(2, "Vegetales libre consumo"),
            FoodCategoryEntity(3, "Vegetales consumo general"),
            FoodCategoryEntity(4, "Frutas"),
            FoodCategoryEntity(5, "Lácteos"),
            FoodCategoryEntity(6, "Carnes bajas en grasas"),
            FoodCategoryEntity(7, "Alimentos ricos en lípidos"),
            FoodCategoryEntity(8, "Aceites y grasas")
        )
    }

    override suspend fun initFoodCategories() :ResultViewState {
        return withContext(ioDispatcher) {
            try {
                foodCategories.forEach { foodCategoryDao.insert(it) }
                ResultViewState.Success("Food categories initialized")
            } catch (e: Exception) {
                ResultViewState.Error(e)
            }
        }
    }
}