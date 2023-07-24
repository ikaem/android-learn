package xyz.imkaem.first_my_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.imkaem.first_my_compose.restaurants.presentation.details.RestaurantDetailsViewModel

@Composable
fun RestaurantDetailsScreen() {
//    this seems to be some helper function
    val viewModel: RestaurantDetailsViewModel = viewModel()
    val item = viewModel.state.value

    if (item != null) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            RestaurantIcon(
                icon = Icons.Filled.Place, modifier = Modifier.padding(
                    top = 32.dp,
                    bottom = 32.dp
                )
            )

            RestaurantDetails(
                title = item.title, description = item.description,
                modifier = Modifier.padding(
                    bottom = 32.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            )

            Text(text = "More info coming soon")
//            this is delta

        }
//        something
    }
}