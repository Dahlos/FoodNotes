package com.dahlos.foodnotes.data.local

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dahlos.foodnotes.data.local.dao.FoodCategoryDao
import com.dahlos.foodnotes.data.local.entities.FoodCategoryEntity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AppDatabaseCallback(private val foodCategoryDao: FoodCategoryDao) : RoomDatabase.Callback(), KoinComponent {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        populateFoodCategories()
    }

    private fun populateFoodCategories() {
        foodCategoryDao.insert(FoodCategoryEntity(1, "Cereales"))
        foodCategoryDao.insert(FoodCategoryEntity(2, "Vegetales libre consumo"))
        foodCategoryDao.insert(FoodCategoryEntity(3, "Vegetales consumo general"))
        foodCategoryDao.insert(FoodCategoryEntity(4, "Frutas"))
        foodCategoryDao.insert(FoodCategoryEntity(5, "Lácteos"))
        foodCategoryDao.insert(FoodCategoryEntity(6, "Carnes bajas en grasas"))
        foodCategoryDao.insert(FoodCategoryEntity(7, "Alimentos ricos en lípidos"))
        foodCategoryDao.insert(FoodCategoryEntity(8, "Aceites y grasas"))
    }

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
    }
}