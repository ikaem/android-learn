package xyz.imkaem.first_my_compose

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RestaurantsApplication: Application() {

//    not needed because we use hitl to provide context
//    init {
//        app = this
//    }
//
//    companion object {
//        private lateinit var app: RestaurantsApplication
//
//        fun getAppContext(): Context {
//            return app.applicationContext
//        }
//    }
}