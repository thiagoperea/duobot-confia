package com.thiagoperea.duobotconfia.presentation.api_data

import com.thiagoperea.duobotconfia.data.api.RiotService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ApiDataPresenter(
    val screen: ApiDataActivity,
    val riotApi: RiotService
) {

    fun loadApiData() {

        CoroutineScope(Dispatchers.Main).launch {
            screen.showLoading()

            // versions loading
            val allVersions = withContext(Dispatchers.IO) {
                riotApi.listVersions()
            }
            val latestVersion = allVersions.first()

            // champion data loading
            val championData = withContext(Dispatchers.IO) {
                riotApi.getAllChampions(latestVersion)
            }
            val championList = championData.data.values.toList()

            // filtering champion tags
            val championTagsAvailable = championList.flatMap { it.roles }.distinctBy { it }

            screen.hideLoading()

            screen.showVersion(latestVersion)
            screen.showChampionData(championList, latestVersion)
            screen.showAvailableTags(championTagsAvailable)
        }
    }
}