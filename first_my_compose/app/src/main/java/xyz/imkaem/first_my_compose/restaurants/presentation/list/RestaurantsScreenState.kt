package xyz.imkaem.first_my_compose.restaurants.presentation.list

import xyz.imkaem.first_my_compose.restaurants.domain.Restaurant

data class RestaurantsScreenState(
    val restaurants: List<Restaurant>,
    val isLoading: Boolean,
    val error: String? = null,
)