package com.tila.halloffame.data


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    var extension: String? = null,
    @SerializedName("path")
    var path: String? = null
)