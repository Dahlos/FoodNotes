package com.dahlos.foodnotes.data.datasource.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dahlos.foodnotes.presentation.ui.models.FoodCategoryModel

@Entity
data class FoodCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "category")
    val category: String
)

fun FoodCategoryEntity.toFoodCategoryModel() = FoodCategoryModel(id = id, category = category)

fun List<FoodCategoryEntity>.toFoodCategoryModelList() = map { it.toFoodCategoryModel() }