package com.dahlos.foodnotes.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dahlos.foodnotes.data.datasource.local.entities.FoodCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: FoodCategoryEntity)

    @Query("SELECT * FROM FoodCategoryEntity")
    fun getAll(): List<FoodCategoryEntity>
}