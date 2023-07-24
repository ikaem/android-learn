package xyz.imkaem.first_my_compose.restaurants.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.imkaem.first_my_compose.RestaurantsApplication
import xyz.imkaem.first_my_compose.restaurants.data.local.LocalRestaurant
import xyz.imkaem.first_my_compose.restaurants.data.local.PartialLocalRestaurant
import xyz.imkaem.first_my_compose.restaurants.data.local.RestaurantsDao
import xyz.imkaem.first_my_compose.restaurants.data.local.RestaurantsDb
import xyz.imkaem.first_my_compose.restaurants.data.remote.RestaurantApiService
import xyz.imkaem.first_my_compose.restaurants.domain.Restaurant
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestaurantsRepository @Inject constructor(
    private val restaurantsDao: RestaurantsDao,
    private val restInterface: RestaurantApiService
) {

//    private val restInterface: RestaurantApiService = Retrofit.Builder().addConverterFactory(
//        GsonConverterFactory.create()
//    )
//        .baseUrl("https://compose-restraurants-default-rtdb.europe-west1.firebasedatabase.app/")
//        .build()
//        .create(RestaurantApiService::class.java)
//    private val restaurantsDao: RestaurantsDao =
//        RestaurantsDb.getDaoInstance(RestaurantsApplication.getAppContext())
//
//    //    data manipulation
    suspend fun toggleFavoriteRestaurant(id: Int, value: Boolean) {
        return withContext(Dispatchers.IO) {
            restaurantsDao.update(PartialLocalRestaurant(id, value))
//            return@withContext getAllRestaurants()
////                .sortedBy { it.title }
        }
    }

    suspend fun getRestaurants(): List<Restaurant> {
        return withContext(Dispatchers.IO) {
            restaurantsDao.getAll().map {
//                seems this return is not needed
                Restaurant(
                    it.id,
                    it.title,
                    it.description,
                    it.isFavorite,
                )
            }
        }
    }

    suspend fun loadRestaurants() {
        return withContext(Dispatchers.IO) {
            try {
//                just need to update, nothing elase
                refreshCache()


            } catch (e: Exception) {

                when (e) {
                    is UnknownHostException,
                    is ConnectException,
                    is HttpException -> {
                        if (restaurantsDao.getAll()
                                .isEmpty()
                        ) throw Exception("Something went wrong. We have no data")
                    }
                    else -> throw e
                }


            }
// if leave out return@withContext, it will return the last line of code
//            restaurantsDao.getAll()
//            return@withContext restaurantsDao.getAll()
        }

    }

    private suspend fun refreshCache() {
        val remoteRestaurants = restInterface.getRestaurants()
        val favoritedRestaurants = restaurantsDao.getAllFavorited()

        restaurantsDao.insertAll(remoteRestaurants.map {
            LocalRestaurant(
                it.id,
                it.title,
                it.description,
                false,
            )
        })
        restaurantsDao.updateAll(favoritedRestaurants.map {
            PartialLocalRestaurant(it.id, true)
        })

    }
}