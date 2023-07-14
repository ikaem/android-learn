package xyz.imkaem.first_my_compose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantsViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {

    val restaurantsState = mutableStateOf(emptyList<Restaurant>())
    val errorState: MutableState<Boolean> = mutableStateOf(false)

    //    define instance of our rest interface
    private lateinit var restInterface: RestaurantApiService
    private val errorHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            errorState.value = true
            exception.printStackTrace()
        }


    //    courutine related
    val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.IO)

//    no need for this because we will use coroutines and their scope
//    private lateinit var restaurantCall: Call<List<Restaurant>>


    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            ).baseUrl(
                "https://compose-restraurants-default-rtdb.europe-west1.firebasedatabase.app/"
            )
            .build()

        restInterface = retrofit.create(
            RestaurantApiService::class.java
        )

        getRestaurants()
    }

    private suspend fun getRemoteRestautants(): List<Restaurant> {
        return withContext(Dispatchers.IO) {
            restInterface.getRestaurants()
        }
    }

    //    with our own coroutine
    private fun getRestaurants() {

//        this does not really work with errors good
//        viewModelScope.launch(Dispatchers.IO + errorHandler) {
//        no need to pass disaptchers to launch now, because whatever degtault, our function cpecified its own dispatcher thread pool
        viewModelScope.launch(errorHandler) {
//            val restaurants = restInterface.getRestaurants()
//            now we can call the above suspend function from any scope with any dispatcher
            val restaurants = getRemoteRestautants()
            withContext(Dispatchers.Main) {
                restaurantsState.value = restaurants.restoreSelections()
            }
        }

//        handling erorr with error handler defined above - coroutines aloo9w for taht

//    TODO no need for this
//        scope.launch {
//        handling error with try catch
//        viewModelScope.launch(Dispatchers.IO) {
//
//            try {
//
//                val restaurants = restInterface.getRestaurants()
//                withContext(Dispatchers.Main) {
//                    state.value = restaurants.restoreSelections()
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
    }


//    fun getRestaurants() = dummyRestaurants

    //    keeping state if view model
//    val state = mutableStateOf(dummyRestaurants)
//    this is getting from state handle
//    val state = mutableStateOf(dummyRestaurants.restoreSelections())
//    with this, we can have intiial empty


    //    this is function to get restaurants from remote - selections stay i guess
//    this is with callbacks
//    private fun getRestaurants() {
////    this is sync fetch
//        // we get bgody from the request
////    we should not use execute becuase it is sync, and runs in main thread
////       restInterface.getRestaurants().execute().body()?.let { restaurants ->
////           seems let will just pass the body data in the bloc
////           state.value = restaurants.restoreSelections()
////
////       }
//
////        we should use enqueue
//
//        restaurantCall = restInterface.getRestaurants()
//        restaurantCall.enqueue(
//            object : Callback<List<Restaurant>> {
//                override fun onResponse(
//                    call: Call<List<Restaurant>>,
//                    response: Response<List<Restaurant>>
//                ) {
//                    response.body()?.let { restaurants ->
//                        state.value = restaurants.restoreSelections()
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
//                    t.printStackTrace()
//                }
//
//            }
//        )
//    }

    fun toggleFavorite(id: Int) {
//        now we get stuff as before
        val restaurants = restaurantsState.value.toMutableList()
        val itemIndex = restaurants.indexOfFirst { it.id == id }
        val item = restaurants[itemIndex]
        val updatedItem = item.copy(isFavorite = !item.isFavorite)

        storeSelection(updatedItem)

        restaurants[itemIndex] = updatedItem
        restaurantsState.value = restaurants
    }

    private fun storeSelection(item: Restaurant) {
//        HOW ARE we sure that we will get a list here  - because we call to mutable list
//        get reference to this state handle thing
        val savedToggled = stateHandle.get<List<Int>?>(FAVORITES).orEmpty().toMutableList()

        if (item.isFavorite) savedToggled.add(item.id)
        else savedToggled.remove(item.id)

//       now set data again
        stateHandle[FAVORITES] = savedToggled

    }

    companion object {
        private const val FAVORITES = "favorites"
    }

    //i guess this returns list of restrainst
    private fun List<Restaurant>.restoreSelections(): List<Restaurant> {
//    this is actually this list of restraints here
//        val me = this

//
//    now here i guess we manipulate that same list
        stateHandle.get<List<Int>?>(FAVORITES)?.let { favoritedIds ->
//            ok, here this is list of restaurants
            // it is single restaurant
//            so it is a map
            val restaurantsMap = this.associateBy { it.id }

//            now we loop over all selected ids and say that if individual rest id is in the map, we will set its favorit eto trhe
            favoritedIds.forEach { id -> restaurantsMap[id]?.isFavorite = true }


            // then we return values of the map
            return restaurantsMap.values.toList()

//            what does actually set new list into this? let?


        }
//            then we retur nthis
        return this
    }

    suspend fun storeUser() {
//        some blocking action
    }

//    just test - this is not good way to call a suspend function
//    fun saveDetails() {
//        startAnimation()
//        storeUser()
//        stopAnimation()
//    }

//    here we create and launch a coroutine
//    fun saveDetails() {
//        GlobalScope.launch ( Dispatchers.IO) {
//            startAnimation()
//            storeUser()
//            stopAnimation()
//        }
//    }
//    we can use lifecycle sope of the Lifecycle owner isntance
//    fun saveDetails() {
////    this is if we are in a fragment or activity
////        lifecycleScope.launch {
//
////    this is if we are in a view model
//        viewModelScope.launch(Dispatchers.IO) {
//        viewModelScope.launch {
//            startAnimation()
//            storeUser()
//            stopAnimation()
//        }
//
//    }
//    createing custom scope
//    we need some job
//    val job = Job()
//
//    // we then need to create scope by passing it contenct
//    val context: CoroutineContext = job + Dispatchers.IO
////    and now this sic courtine scope
//    val myScope: CoroutineScope = CoroutineScope(context)

//    we can cancel job - this cancel all coroutines in this scope
//    job.cancel()


    // we get context by adding job and isplatchers

    override fun onCleared() {
        super.onCleared()
        job.cancel()
//        no need because we dont have the call object anymore
//        restaurantCall.cancel()

    }
}


