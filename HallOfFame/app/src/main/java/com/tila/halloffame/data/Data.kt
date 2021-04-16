package com.tila.halloffame.data


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("limit")
    var limit: Int? = null,
    @SerializedName("offset")
    var offset: Int? = null,
    @SerializedName("results")
    var results: List<Result>? = null,
    @SerializedName("total")
    var total: Int? = null
)