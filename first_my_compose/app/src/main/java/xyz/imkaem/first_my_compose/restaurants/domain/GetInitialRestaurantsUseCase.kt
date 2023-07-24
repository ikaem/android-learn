package xyz.imkaem.first_my_compose.restaurants.domain

import xyz.imkaem.first_my_compose.restaurants.data.RestaurantsRepository
import javax.inject.Inject

class GetInitialRestaurantsUseCase @Inject constructor(
    private val repository: RestaurantsRepository,
    private val getSortedRestaurantsUseCase: GetSortedRestaurantsUseCase,
) {
//    private val repository: RestaurantsRepository = RestaurantsRepository()
//    private val getSortedRestaurantsUseCase: GetSortedRestaurantsUseCase =
//        GetSortedRestaurantsUseCase()

    suspend operator fun invoke(): List<Restaurant> {
        repository.loadRestaurants()
        return getSortedRestaurantsUseCase()
    }
}

// temp only - why we use operator fun?
//val useCase = GetRestaurantsUseCase()
//val result = useCase()