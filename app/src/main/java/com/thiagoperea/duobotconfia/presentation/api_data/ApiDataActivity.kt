package com.thiagoperea.duobotconfia.presentation.api_data

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.thiagoperea.duobotconfia.R
import com.thiagoperea.duobotconfia.data.api.RiotService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiDataActivity : AppCompatActivity() {

    val riotService = createService()
    val presenter = ApiDataPresenter(this, riotService)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_data)

        setupListeners()
    }

    private fun setupListeners() {
        findViewById<Button>(R.id.loadDataButton).setOnClickListener {
            presenter.loadApiData()
        }
    }

    fun showLoading() {
        findViewById<View>(R.id.loadingIndicator).visibility = View.VISIBLE
    }

    fun hideLoading() {
        findViewById<View>(R.id.loadingIndicator).visibility = View.GONE
    }

    fun showVersions(versions: List<String>) {
        findViewById<TextView>(R.id.responsePlaceholder).text = versions.toString()
    }

    private fun createService(): RiotService {
        return Retrofit.Builder()
            .baseUrl("https://ddragon.leagueoflegends.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotService::class.java)
    }
}