package com.example.android4a_aurelienandrieux.injection

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.android4a_aurelienandrieux.R
import com.example.android4a_aurelienandrieux.data.local.AppDatabase
import com.example.android4a_aurelienandrieux.data.local.DatabaseDao
import com.example.android4a_aurelienandrieux.data.local.models.ZeldaGames
import com.example.android4a_aurelienandrieux.data.remote.LozApi
import com.example.android4a_aurelienandrieux.data.repository.UserRepository
import com.example.android4a_aurelienandrieux.domain.usecase.CreateUserUseCase
import com.example.android4a_aurelienandrieux.domain.usecase.GetUserUseCase
import com.example.android4a_aurelienandrieux.presentation.list.ListViewModel
import com.example.android4a_aurelienandrieux.presentation.main.MainViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//file that creates all classes

val presentationModule = module {
    factory { MainViewModel(get(), get()) } //factory -> destroys the model when changing model, recreates one whenever you need it ; single pour singleton
    factory { ListViewModel() }
}

val domainModule = module {
    factory { CreateUserUseCase(get())}
    factory { GetUserUseCase(get())}
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
//    single { createGson() }
//    single { createApi(androidContext()) }
//    single { createSharedPreferences(androidContext())}
//    single { getLozGamesList(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}

//fun createGson(): Gson {
//    return GsonBuilder()
//        .setLenient()
//        .create()
//}

//fun createApi(context: Context): LozApi{
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(context.getString(R.string.BASE_URL))
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    return retrofit.create(LozApi::class.java)
//}

//fun createSharedPreferences(context: Context): SharedPreferences? {
//    return context.getSharedPreferences("app_AA", Context.MODE_PRIVATE)
//}

//fun getLozGamesList(context: Context?): List<ZeldaGames?>? {
//        val jsonLozGames: String? = context?.let { createSharedPreferences(it)?.getString(context.getString(R.string.KEY_LOZGAMES_LIST), null) }
//
//    return gson.fromJson(jsonLozGames, object: TypeToken<List<ZeldaGames?>?>(){}.type)
//
//}