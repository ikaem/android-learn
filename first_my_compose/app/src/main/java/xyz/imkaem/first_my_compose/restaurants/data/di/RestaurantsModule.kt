package xyz.imkaem.first_my_compose.restaurants.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.imkaem.first_my_compose.restaurants.data.local.RestaurantsDao
import xyz.imkaem.first_my_compose.restaurants.data.local.RestaurantsDb
import xyz.imkaem.first_my_compose.restaurants.data.remote.RestaurantApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestaurantsModule {
    //    object is singleton?


    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext appContext: Context
    ): RestaurantsDb {
        return Room
            .databaseBuilder(
                appContext,
                RestaurantsDb::class.java,
                "restaurants_database"
            ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideRoomDao(database: RestaurantsDb): RestaurantsDao = database.dao

    //    retrofit
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://compose-restraurants-default-rtdb.europe-west1.firebasedatabase.app/")
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): RestaurantApiService {
        return retrofit.create(RestaurantApiService::class.java)
    }
}