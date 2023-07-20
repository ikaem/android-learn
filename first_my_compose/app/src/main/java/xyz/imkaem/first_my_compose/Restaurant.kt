package xyz.imkaem.first_my_compose

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey()
    @ColumnInfo(name = "r_id")
    @SerializedName("r_id")
    val id: Int,

    @ColumnInfo(name = "r_title")
    @SerializedName("r_title")
    val title: String,

    @ColumnInfo(name = "r_description")
    @SerializedName("r_description")
    val description: String,

//    NOT HERE
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false
)

/*
val dummyRestaurants = listOf<Restaurant>(
    Restaurant(
        id = 1,
        title = "Restaurant 1",
        description = "This is the first restaurant"
    ),
    Restaurant(
        id = 2,
        title = "Restaurant 2",
        description = "This is the second restaurant"
    ),
    Restaurant(
        id = 3,
        title = "Restaurant 3",
        description = "This is the third restaurant"
    ),
    Restaurant(
        id = 4,
        title = "Restaurant 4",
        description = "This is the fourth restaurant"
    ),
    Restaurant(
        id = 5,
        title = "Restaurant 5",
        description = "This is the fifth restaurant"
    ),
    Restaurant(
        id = 6,
        title = "Restaurant 6",
        description = "This is the sixth restaurant"
    ),
    Restaurant(
        id = 7,
        title = "Restaurant 7",
        description = "This is the seventh restaurant"
    ),
    Restaurant(
        id = 8,
        title = "Restaurant 8",
        description = "This is the eighth restaurant"
    ),
    Restaurant(
        id = 9,
        title = "Restaurant 9",
        description = "This is the ninth restaurant"
    ),
    Restaurant(
        id = 10,
        title = "Restaurant 10",
        description = "This is the tenth restaurant"
    ),
    Restaurant(
        id = 11,
        title = "Restaurant 11",
        description = "This is the eleventh restaurant"
    ),
    Restaurant(
        id = 12,
        title = "Restaurant 12",
        description = "This is the twelfth restaurant"
    ),
    Restaurant(
        id = 13,
        title = "Restaurant 13",
        description = "This is the thirteenth restaurant"
    ),


    )*/
