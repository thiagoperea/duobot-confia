package com.thiagoperea.duobotconfia.data.model

import com.google.gson.annotations.SerializedName

data class Champion(
    val name: String,
    val title: String,
    @SerializedName("blurb") val story: String,
    @SerializedName("info") val stats: ChampionStats,
    @SerializedName("tags") val roles: List<String>,
)

data class ChampionStats(
    val attack: Int,
    val defense: Int,
    val magic: Int,
    val difficulty: Int,
)
