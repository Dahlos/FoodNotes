package com.dahlos.foodnotes.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dahlos.foodnotes.data.datasource.local.dao.FoodCategoryDao
import com.dahlos.foodnotes.data.datasource.local.entities.FoodCategoryEntity

@Database(entities = [FoodCategoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodCategoryDao(): FoodCategoryDao
    companion object {
        const val DATABASE_NAME = "food_notes_db"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            when (INSTANCE) {
                null -> {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }

//        private val CALLBACK = object : RoomDatabase.Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                populateCategories()
//            }
//        }
//
//        private fun populateCategories() {
//            val foodCategoryDao = INSTANCE?.foodCategoryDao()
//            foodCategoryDao?.insert(FoodCategoryEntity(1, "Cereales"))
//            foodCategoryDao?.insert(FoodCategoryEntity(2, "Vegetales libre consumo"))
//            foodCategoryDao?.insert(FoodCategoryEntity(3, "Vegetales consumo general"))
//            foodCategoryDao?.insert(FoodCategoryEntity(4, "Frutas"))
//            foodCategoryDao?.insert(FoodCategoryEntity(5, "Lácteos"))
//            foodCategoryDao?.insert(FoodCategoryEntity(6, "Carnes bajas en grasas"))
//            foodCategoryDao?.insert(FoodCategoryEntity(7, "Alimentos ricos en lípidos"))
//            foodCategoryDao?.insert(FoodCategoryEntity(8, "Aceites y grasas"))
//        }
    }
}