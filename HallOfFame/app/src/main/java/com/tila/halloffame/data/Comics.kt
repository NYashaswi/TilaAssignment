package com.tila.halloffame.data


import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("available")
    var available: Int? = null,
    @SerializedName("collectionURI")
    var collectionURI: String? = null,
    @SerializedName("items")
    var items: List<Item>? = null,
    @SerializedName("returned")
    var returned: Int? = null
)