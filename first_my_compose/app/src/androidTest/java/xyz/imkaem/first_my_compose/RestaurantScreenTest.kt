package xyz.imkaem.first_my_compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import xyz.imkaem.first_my_compose.restaurants.data.DummyContent
import xyz.imkaem.first_my_compose.restaurants.presentation.Description
import xyz.imkaem.first_my_compose.restaurants.presentation.list.RestaurantsScreenState
import xyz.imkaem.first_my_compose.ui.theme.First_my_composeTheme

class RestaurantScreenTest {

    @get: Rule
    val testRule: ComposeContentTestRule = createComposeRule()

    //    first test - focus only one thing
    @Test
    fun initialState_isRendered() {

        val state = RestaurantsScreenState(listOf(), true)

        testRule.setContent {
            First_my_composeTheme {
                RestaurantsScreen(
                    state,
                    { _, _ -> },
                    {}
                )
            }
        }

        testRule.onNodeWithContentDescription(Description.RESTAURANTS_LOADING).assertIsDisplayed()
    }

    @Test
    fun withContentState_isRendered() {
        val state = RestaurantsScreenState(DummyContent.getDomainRestaurants(), false)

        testRule.setContent {
            First_my_composeTheme {
                RestaurantsScreen(
                    state,
                    { _, _ -> },
                    {}
                )
            }
        }

        testRule.onNodeWithText(DummyContent.getDomainRestaurants()[0].title).assertIsDisplayed()
        testRule.onNodeWithContentDescription(Description.RESTAURANTS_LOADING).assertDoesNotExist()
    }

    @Test
    fun withContentState_ClickOnItem_isRegistered() {
        val restaurants = DummyContent.getDomainRestaurants()
        val targetRestaurant = restaurants.first()

        val state = RestaurantsScreenState(restaurants, false)

        testRule.setContent {

            First_my_composeTheme {
                RestaurantsScreen(
                    state,
                    { _, _ -> },
                    { id -> assert(id == targetRestaurant.id) }
                )
            }
        }

        testRule.onNodeWithText(targetRestaurant.title).performClick()
    }

}