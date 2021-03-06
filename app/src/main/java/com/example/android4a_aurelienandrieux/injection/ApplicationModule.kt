package com.example.android4a_aurelienandrieux.injection

import android.content.Context
import androidx.room.Room
import com.example.android4a_aurelienandrieux.data.local.AppDatabase
import com.example.android4a_aurelienandrieux.data.local.DatabaseDao
import com.example.android4a_aurelienandrieux.data.repository.UserRepository
import com.example.android4a_aurelienandrieux.domain.usecase.CreateUserUseCase
import com.example.android4a_aurelienandrieux.domain.usecase.GetUserUseCase
import com.example.android4a_aurelienandrieux.presentation.list.ListViewModel
import com.example.android4a_aurelienandrieux.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(), get()) }
    factory { ListViewModel() }
}

val domainModule = module {
    factory { CreateUserUseCase(get())}
    factory { GetUserUseCase(get())}
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}