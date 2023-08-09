package com.dahlos.foodnotes.di

import androidx.room.Room
import com.dahlos.foodnotes.data.local.AppDatabase
import com.dahlos.foodnotes.data.local.AppDatabase.Companion.DATABASE_NAME
import com.dahlos.foodnotes.data.local.AppDatabaseCallback
import com.dahlos.foodnotes.data.local.dao.FoodCategoryDao
import com.dahlos.foodnotes.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val appModule = module {
//    single {
//        Room.databaseBuilder(
//            androidContext(),
//            AppDatabase::class.java,
//            DATABASE_NAME
//        ).addCallback(get<AppDatabaseCallback>())
//            .build()
//    }

//    single{
//        Room.databaseBuilder(
//            androidContext(),
//            AppDatabase::class.java,
//            DATABASE_NAME
//        )
//            .build()
//    }

//    single { AppDatabaseCallback(get()) }
    single { AppDatabase.getInstance(androidContext()).foodCategoryDao()}
//    single { get<AppDatabase>().foodCategoryDao()}
    viewModel { MainViewModel(get()) }
}