package xyz.imkaem.first_my_compose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantDetailsViewModel(
    private val stateHandle: SavedStateHandle,
) : ViewModel() {
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

//        this is test
        val id = stateHandle.get<Int>("restaurant_id")?: 0

//        calling to get data
        viewModelScope.launch {
            val restaurant = getRemoteRestaurant(id)
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