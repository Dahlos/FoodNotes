package com.dahlos.foodnotes.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dahlos.foodnotes.data.local.dao.FoodCategoryDao
import com.dahlos.foodnotes.data.local.entities.FoodCategoryEntity

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

//        private val roomCallback = object : RoomDatabase.Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                // Llama al método para insertar las categorías iniciales
//                populateCategories()
//            }
//        }
//
//        private fun populateCategories() {
//            val categoryDao = INSTANCE?.categoryDao()
//            categoryDao?.insert(Category("Categoría 1"))
//            categoryDao?.insert(Category("Categoría 2"))
//            // ... y así sucesivamente
//        }
    }
}