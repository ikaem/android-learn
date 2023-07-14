package xyz.imkaem.first_my_compose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantDetailsViewModel() : ViewModel() {
    private lateinit var restInterface: RestaurantApiService

    val state = mutableStateOf<Restaurant?>(null)

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl("https://compose-restraurants-default-rtdb.europe-west1.firebasedatabase.app/")
            .build()

        restInterface = retrofit.create(RestaurantApiService::class.java)

//        calling to get data
        viewModelScope.launch {
            val restaurant = getRemoteRestaurant(2)
            state.value = restaurant
        }

    }

    private suspend fun getRemoteRestaurant(id: Int): Restaurant {
        return withContext(Dispatchers.IO) {
            val responseMap: Map<Int, Restaurant> = restInterface.getRestaurant(id)

            return@withContext responseMap.values.first()
        }
    }

}