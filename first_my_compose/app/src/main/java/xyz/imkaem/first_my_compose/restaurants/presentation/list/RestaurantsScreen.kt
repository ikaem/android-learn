package xyz.imkaem.first_my_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.imkaem.first_my_compose.restaurants.domain.Restaurant
import xyz.imkaem.first_my_compose.restaurants.presentation.Description
import xyz.imkaem.first_my_compose.restaurants.presentation.list.RestaurantsScreenState
import xyz.imkaem.first_my_compose.restaurants.presentation.list.RestaurantsViewModel

@Composable
fun RestaurantsScreen(
    state: RestaurantsScreenState,
    onFavoriteClick: (id: Int, oldValue: Boolean) -> Unit,
    onItemClick: (id: Int) -> Unit = {}
) {
//    show how to use corutine scope here
/*    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = "save user", block = {
//        now we use scope
        scope.launch(Dispatchers.IO) {
//            now some suspend function here

        }
    } )*/


//    Tghis is actually instantiating it here
//    val viewModel: RestaurantsViewModel = viewModel()
////    val restaurants = viewModel.restaurantsState.value;
////    val isLoading: Boolean = restaurants.isEmpty();
//    val state = viewModel.state.value;

//    now making remote request
//    not a greate solution
//    viewModel.getRestaurants()

//    better solutiuion
//    note that the block is trailing lambda
//    might not be best because configuraiton change happens on device rortaiton because activity of this is destroy ed on cofnigrtaiton change - so we get rebuild and create a new call
//    LaunchedEffect("request_restaurants") {
//        viewModel.getRestaurants()
//    }

//    state of resturaint items
//    val state: MutableState<List<Restaurant>> = remember {
////    to prevent losing data on rotration
////    val state: MutableState<List<Restaurant>> = rememberSaveable {
//        mutableStateOf(viewModel.getRestaurants())
//    }

//    RestaurantItem()

//    Column(
//        Modifier.verticalScroll(rememberScrollState())
//    ) {
//        dummyRestaurants.forEach { restaurant ->
//            RestaurantItem(restaurant)
//        }
//    }

//    this is lazy
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(
                vertical = 8.dp,
                horizontal = 16.dp
            )
        )
        {
            //        item(viewModel.errorState.value) {
            //            if (viewModel.errorState.value) {
            //                Text(text = "Error getting restaurants")
            //            }
            //            Text("what")
            //        }
            //        TODO old
            //        items(dummyRestaurants) { restaurant ->
            //        items(state.value) { restaurant ->
            items(state.restaurants) { restaurant ->
                RestaurantItem(
                    restaurant,
                    onFavoriteClick = { id, oldValue -> onFavoriteClick(id, oldValue) },
                    onItemClick = { id -> onItemClick(id) }
                    //                onItemClick = { id -> viewModel.onItemClicked(id) }
                    //                onClick = viewModel::toggleFavorite
                    //                onClick = { id ->
                    //
                    //                    //                get restraints
                    //                    val restaurants = state.value.toMutableList()
                    //
                    ////                get current item index
                    //                    val itemIndex = restaurants.indexOfFirst {
                    //                        it.id == id
                    //                    }
                    //
                    ////                then get item
                    //                    val item = restaurants[itemIndex]
                    //
                    ////                then something to copy into item index
                    //                    val updatedItem: Restaurant = item.copy(isFavorite = !item.isFavorite)
                    //                    restaurants[itemIndex] = updatedItem
                    //
                    ////                and then set value of restaurants
                    //                    state.value = restaurants
                    //
                    //                }
                )
                //            { id ->
                ////                get restraints
                //                val restaurants = state.value.toMutableList()
                //
                ////                get current item index
                //                val itemIndex = restaurants.indexOfFirst {
                //                    it.id == id
                //                }
                //
                ////                then get item
                //                val item = restaurants[itemIndex]
                //
                ////                then something to copy into item index
                //                val updatedItem: Restaurant = item.copy(isFavorite = !item.isFavorite)
                //                restaurants[itemIndex] = updatedItem
                //
                ////                and then set value of restaurants
                //                state.value = restaurants
                //
                //
                //            }
            }
        }
        if (state.isLoading) CircularProgressIndicator(
            Modifier.semantics {
                this.contentDescription = Description.RESTAURANTS_LOADING
            }
        )
        if (state.error != null) {
            Text(text = state.error)
        }
    }
}


@Composable
fun RestaurantItem(
    restaurant: Restaurant,
    onFavoriteClick: (id: Int, oldValue: Boolean) -> Unit,
    onItemClick: (id: Int) -> Unit,
) {
//    val favoriteState: MutableState<Boolean> = remember {
//        mutableStateOf(false)
//    }

    val icon: ImageVector = if (restaurant.isFavorite) {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }



    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(restaurant.id) }
    ) {

//        this is i guess drawing inside the card
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            RestaurantIcon(
                Icons.Filled.Place,
                Modifier.weight(0.15f)

            )
            RestaurantDetails(
                restaurant.title,
                restaurant.description,
                Modifier.weight(0.7f)
            )
            RestaurantIcon(
                icon,
                Modifier.weight(0.15f),
//                { favoriteState.value = !favoriteState.value })
            ) {
                onFavoriteClick(restaurant.id, restaurant.isFavorite)
            }
//            FavoriteIcon(Modifier.weight(0.15f))
        }
    }
}

//
//TOOD not needed
@Composable
fun FavoriteIcon(modifier: Modifier, icon: ImageVector, onClick: () -> Unit) {

//    val favoriteState: MutableState<Boolean> = remember {
//        mutableStateOf(false)
//    }
//
//    val icon: ImageVector = if (favoriteState.value) {
//        Icons.Filled.Favorite
//    } else {
//        Icons.Filled.FavoriteBorder
//    }


    Image(
        imageVector = icon,
        contentDescription = "Favorite Icon",
        modifier = modifier
            .padding(8.dp)
            .clickable {
                onClick()
            }
    )
}

@Composable
fun RestaurantIcon(icon: ImageVector, modifier: Modifier, onClick: () -> Unit = {}) {
    Image(
        imageVector = icon,
        contentDescription = "Restaurant Icon",
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() }
    )
}

@Composable
fun RestaurantDetails(
    title: String,
    description: String,
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment,
    ) {
        Text(text = title, style = MaterialTheme.typography.h6)
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(text = description, style = MaterialTheme.typography.body2)

        }
    }
}