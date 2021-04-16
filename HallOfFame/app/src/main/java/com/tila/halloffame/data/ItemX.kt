package com.tila.halloffame.data


import com.google.gson.annotations.SerializedName

data class ItemX(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("resourceURI")
    var resourceURI: String? = null
)