package com.thiagoperea.duobotconfia.data.api

import com.thiagoperea.duobotconfia.data.model.ChampionApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RiotService {

    @GET("api/versions.json")
    suspend fun listVersions(): List<String>

    @GET("cdn/{game_version}/data/en_US/champion.json")
    suspend fun getAllChampions(@Path("game_version") gameVersion: String): ChampionApiResponse
}