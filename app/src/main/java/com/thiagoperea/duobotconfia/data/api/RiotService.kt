package com.thiagoperea.duobotconfia.data.api

import com.thiagoperea.duobotconfia.data.model.ChampionApiResponse
import com.thiagoperea.duobotconfia.data.model.SpellsApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RiotService {

    @GET("api/versions.json")
    suspend fun listVersions(): List<String>

    @GET("cdn/{game_version}/data/en_US/champion.json")
    suspend fun getAllChampions(@Path("game_version") gameVersion: String): ChampionApiResponse

    @GET("cdn/{game_version}/data/en_US/summoner.json")
    suspend fun getAllSpells(@Path("game_version") gameVersion: String): SpellsApiResponse
}

// TODO: example of square image
// http://ddragon.leagueoflegends.com/cdn/12.21.1/img/champion/Aatrox.png