package com.tila.halloffame.data


import com.google.gson.annotations.SerializedName

data class Stories(
    @SerializedName("available")
    var available: Int? = null,
    @SerializedName("collectionURI")
    var collectionURI: String? = null,
    @SerializedName("items")
    var items: List<ItemXXX>? = null,
    @SerializedName("returned")
    var returned: Int? = null
)