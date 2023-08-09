package com.dahlos.foodnotes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dahlos.foodnotes.data.local.entities.FoodCategoryEntity

@Dao
interface FoodCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: FoodCategoryEntity)

    @Query("SELECT * FROM FoodCategoryEntity")
    fun getAll(): List<FoodCategoryEntity>
}