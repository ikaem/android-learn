package xyz.imkaem.first_my_compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RestaurantDetailsScreen() {
//    this seems to be some helper function
    val viewModel: RestaurantDetailsViewModel = viewModel()
    val item = viewModel.state.value

    if(item != null) {
//        something
    }
}