package com.thiagoperea.duobotconfia.data.model

import com.google.gson.annotations.SerializedName

data class SpellsApiResponse(
    val data: Map<String, AllSpellsResponse>

)

data class AllSpellsResponse(
    val name: String,
    val image: SpellImageResponse,
    val modes: List<String>
)

data class SpellImageResponse(
    @SerializedName("full") val squareImgUrl: String
)

