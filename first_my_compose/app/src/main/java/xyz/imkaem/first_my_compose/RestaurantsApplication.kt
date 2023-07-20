package xyz.imkaem.first_my_compose

import android.app.Application
import android.content.Context

class RestaurantsApplication: Application() {

    init {
        app = this
    }

    companion object {
        private lateinit var app: RestaurantsApplication

        fun getAppContext(): Context {
            return app.applicationContext
        }
    }
}