package com.dahlos.foodnotes.di

import androidx.room.Room
import com.dahlos.foodnotes.data.datasource.local.AppDatabase
import com.dahlos.foodnotes.data.datasource.local.AppDatabase.Companion.DATABASE_NAME
import com.dahlos.foodnotes.data.datasource.local.AppDatabaseCallback
import com.dahlos.foodnotes.data.datasource.local.dao.FoodCategoryDao
import com.dahlos.foodnotes.data.datasource.repository.FoodCategoriesRepository
import com.dahlos.foodnotes.data.datasource.repository.impl.FoodCategoriesRepositoryImpl
import com.dahlos.foodnotes.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val appModule = module {
    single { AppDatabase.getInstance(androidContext()).foodCategoryDao() }
    viewModel { MainViewModel(get()) }
    factory<FoodCategoriesRepository> { FoodCategoriesRepositoryImpl(get()) }
}