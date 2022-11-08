package com.thiagoperea.duobotconfia.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thiagoperea.duobotconfia.R
import com.thiagoperea.duobotconfia.presentation.api_data.ApiDataActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.apiDataButton).setOnClickListener {
            val intent = Intent(this, ApiDataActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.getChampionsButton).setOnClickListener {
            Toast.makeText(this, "TESTE", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.qualquerCoisa).setOnClickListener {
            val fazAi = Intent(this, ChampionSelectActivity::class.java)
            startActivity(fazAi)
        }
    }
}