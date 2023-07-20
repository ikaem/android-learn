package xyz.imkaem.first_my_compose

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RestaurantsApp() {

    val navController: NavHostController = rememberNavController();
    NavHost(navController, startDestination = "restaurants") {
        composable(route = "restaurants") {
//            no this - lambda call will also call funciton
//            RestaurantScreen()
            RestaurantScreen { id ->
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