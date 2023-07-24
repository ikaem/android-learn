package xyz.imkaem.first_my_compose.restaurants.domain

import xyz.imkaem.first_my_compose.restaurants.data.RestaurantsRepository
import javax.inject.Inject

class ToggleRestaurantUseCase @Inject constructor(
    private val repository: RestaurantsRepository,
    private val getSortedRestaurantsUseCase: GetSortedRestaurantsUseCase
) {
//    private val repository: RestaurantsRepository = RestaurantsRepository()
//    private val getSortedRestaurantsUseCase: GetSortedRestaurantsUseCase =
//        GetSortedRestaurantsUseCase()

    suspend operator fun invoke(id: Int, oldValue: Boolean): List<Restaurant> {
        val newValue = oldValue.not()
        repository.toggleFavoriteRestaurant(id, newValue);
//        not the approach i would take
//        return GetRestaurantsUseCase().invoke()
//        to prevent network request
        return getSortedRestaurantsUseCase()
    }
}