package com.thiagoperea.duobotconfia.presentation.api_data

import com.thiagoperea.duobotconfia.data.api.RiotService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class ApiDataPresenter(
    val screen: ApiDataActivity,
    val riotApi: RiotService
) {

    fun loadApiData() {

        runBlocking(Dispatchers.Main) {
            screen.showLoading()

            val versions = withContext(Dispatchers.IO) {
                riotApi.listVersions()
            }

            screen.hideLoading()
            screen.showVersions(versions)
        }
    }
}