package xyz.imkaem.first_my_compose.restaurants.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
class PartialLocalRestaurant(
    @ColumnInfo(name = "r_id")
    val id: Int,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false,
)