package com.dahlos.foodnotes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlos.foodnotes.data.local.dao.FoodCategoryDao
import com.dahlos.foodnotes.data.local.entities.FoodCategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class MainViewModel(private val foodCategoryDao: FoodCategoryDao) : ViewModel() {

    fun insertFoodCategory() {
        with(Dispatchers.IO){
            foodCategoryDao.insert(FoodCategoryEntity(1, "Cereales"))
            foodCategoryDao.insert(FoodCategoryEntity(2, "Vegetales libre consumo"))
            foodCategoryDao.insert(FoodCategoryEntity(3, "Vegetales consumo general"))
            foodCategoryDao.insert(FoodCategoryEntity(4, "Frutas"))
            foodCategoryDao.insert(FoodCategoryEntity(5, "Lácteos"))
            foodCategoryDao.insert(FoodCategoryEntity(6, "Carnes bajas en grasas"))
            foodCategoryDao.insert(FoodCategoryEntity(7, "Alimentos ricos en lípidos"))
            foodCategoryDao.insert(FoodCategoryEntity(8, "Aceites y grasas"))
        }
    }
}