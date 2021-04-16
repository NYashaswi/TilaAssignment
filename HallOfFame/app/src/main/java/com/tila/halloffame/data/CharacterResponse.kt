package com.tila.halloffame.data


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("attributionHTML")
    var attributionHTML: String? = null,
    @SerializedName("attributionText")
    var attributionText: String? = null,
    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("data")
    var characterData: Data? = null,
    @SerializedName("etag")
    var etag: String? = null,
    @SerializedName("status")
    var status: String? = null
)