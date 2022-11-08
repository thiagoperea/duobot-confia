package com.thiagoperea.duobotconfia.presentation

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.thiagoperea.duobotconfia.R


class ChampionSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion_select)

        findViewById<ImageView>(R.id.imageReturn).setOnClickListener {
            finish()
        }

    }
}