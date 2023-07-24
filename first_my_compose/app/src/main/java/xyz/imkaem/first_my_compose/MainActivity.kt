package xyz.imkaem.first_my_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import xyz.imkaem.first_my_compose.restaurants.presentation.list.RestaurantsScreenState
import xyz.imkaem.first_my_compose.ui.theme.First_my_composeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            First_my_composeTheme {
                RestaurantsApp()
                // A surface container using the 'background' color from the theme
//                RestaurantScreen()
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    First_my_composeTheme {
//        Greeting("Android")
        RestaurantsScreen(
            RestaurantsScreenState(listOf(), true),
            { _, _ -> },
            {}
        )
    }
}