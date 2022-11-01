package com.thiagoperea.duobotconfia.presentation.api_data

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagoperea.duobotconfia.R
import com.thiagoperea.duobotconfia.data.api.RiotService
import com.thiagoperea.duobotconfia.data.model.Champion
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiDataActivity : AppCompatActivity() {

    val riotService = createService()
    val presenter = ApiDataPresenter(this, riotService)
    val adapter = ApiDataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_data)

        setupListeners()
        setupRecyclerView()
    }

    private fun setupListeners() {
        findViewById<Button>(R.id.loadDataButton).setOnClickListener {
            presenter.loadApiData()
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvChampions)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

    fun showLoading() {
        findViewById<View>(R.id.loadingIndicator).visibility = View.VISIBLE
    }

    fun hideLoading() {
        findViewById<View>(R.id.loadingIndicator).visibility = View.GONE
    }

    fun showVersion(latestVersion: String) {
        findViewById<TextView>(R.id.txtLatestVersion).text = getString(R.string.version_description, latestVersion)
    }

    fun showChampionData(championData: List<Champion>, gameVersion: String) {
        adapter.replaceData(championData, gameVersion)
    }

    fun showAvailableTags(championTagsAvailable: List<String>) {
        findViewById<TextView>(R.id.txtAvailableTags).text = getString(R.string.available_tags, championTagsAvailable.toString())
    }
}

// export to DI
fun createService(): RiotService {
    return Retrofit.Builder()
        .baseUrl("https://ddragon.leagueoflegends.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RiotService::class.java)
}