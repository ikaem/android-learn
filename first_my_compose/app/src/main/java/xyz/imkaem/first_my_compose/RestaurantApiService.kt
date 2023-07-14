package xyz.imkaem.first_my_compose

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantApiService {
    @GET("restaurants.json")
//    this is with callbacks
//    fun getRestaurants(): Call<List<Restaurant>>
//    this is suspend function
    suspend fun getRestaurants(): List<Restaurant>

//    function to get single restraunt
    @GET("restaurants.json?orderBy=\"r_id\"")
    suspend fun getRestaurant(@Query("equalTo") id: Int): Map<Int, Restaurant>

}