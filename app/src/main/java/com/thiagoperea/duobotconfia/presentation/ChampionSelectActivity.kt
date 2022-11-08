package com.thiagoperea.duobotconfia.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.thiagoperea.duobotconfia.databinding.ActivityChampionSelectBinding


class ChampionSelectActivity : AppCompatActivity() {

    lateinit var binding: ActivityChampionSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChampionSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageReturn.setOnClickListener {
            finish()
        }

        binding.imageRefresh.setOnClickListener {
            revealChampions()
        }
    }

    private fun revealChampions() {
        binding.imageSupportBack.visibility = View.GONE
        binding.imageCarryBack.visibility = View.GONE
    }
}