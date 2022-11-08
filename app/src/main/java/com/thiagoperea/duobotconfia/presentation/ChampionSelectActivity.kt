package com.thiagoperea.duobotconfia.presentation

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.thiagoperea.duobotconfia.R
import com.thiagoperea.duobotconfia.databinding.ActivityChampionSelectBinding


class ChampionSelectActivity : AppCompatActivity() {

    lateinit var binding: ActivityChampionSelectBinding
    lateinit var buttonSfxPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChampionSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSfx()
        setupButtons()
    }

    override fun onStop() {
        buttonSfxPlayer.release()
        super.onStop()
    }

    private fun setupSfx() {
        buttonSfxPlayer = MediaPlayer.create(this, R.raw.sfx_button_click)
    }

    private fun setupButtons() {
        binding.imageReturn.setOnClickListener {
            finish()
        }

        binding.imageRefresh.setOnClickListener {
            buttonSfxPlayer.start()
            revealChampions()
        }
    }

    private fun revealChampions() {
        binding.imageSupportBack.visibility = View.GONE
        binding.imageCarryBack.visibility = View.GONE
    }
}