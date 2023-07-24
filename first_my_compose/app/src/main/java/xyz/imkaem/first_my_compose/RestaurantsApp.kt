package xyz.imkaem.first_my_compose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xyz.imkaem.first_my_compose.restaurants.presentation.list.RestaurantsViewModel

@Composable
fun RestaurantsApp() {

    val navController: NavHostController = rememberNavController();
    NavHost(navController, startDestination = "restaurants") {
        composable(route = "restaurants") {
//            we initalize view model here
//            val viewModel: RestaurantsViewModel = viewModel()
//            using this for DI purposes
            val viewModel: RestaurantsViewModel = hiltViewModel()
            val state = viewModel.state;
//            no this - lambda call will also call funciton
//            RestaurantScreen()
            RestaurantsScreen(
                state = state.value,
                onFavoriteClick = { id, oldValue ->
                    viewModel.toggleFavorite(id, oldValue)
                }
            ) { id ->
                navController.navigate("restaurants/$id")
            }
        }
        composable(
            route = "restaurants/{restaurant_id}",
            arguments = listOf(
                navArgument("restaurant_id") {
                    type = NavType.IntType

                }
            ),
            deepLinks = listOf(navDeepLink {
                uriPattern =
                    "www.restaurantsapp.details.com/{restaurant_id}"
            })
        ) { navStackEntry ->

//            we dont do this because the view model needs id, not the screen
//            val id = navStackEntry.arguments?.getInt("restaurant_id")
            RestaurantDetailsScreen()
//            this also executes the function

        }

    }

}