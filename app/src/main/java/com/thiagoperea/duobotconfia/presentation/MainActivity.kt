package com.thiagoperea.duobotconfia.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.thiagoperea.duobotconfia.R
import com.thiagoperea.duobotconfia.databinding.ActivityMainBinding
import com.thiagoperea.duobotconfia.presentation.api_data.ApiDataActivity
import com.thiagoperea.duobotconfia.presentation.api_data.createService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButton()


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

        findViewById<Button>(R.id.setSpecButton).setOnClickListener {
            val telinha = Intent(this, SetSpec::class.java)
            startActivity(telinha)
        }
    }

    private fun setupButton() {
        binding.getSpells.setOnClickListener {
            callGetSpellsApi()
        }
    }

    private fun callGetSpellsApi() {
        CoroutineScope(Dispatchers.Main).launch {
            val gameVersion = "12.21.1"

            val spellsData = withContext(Dispatchers.IO) {
                createService().getAllSpells(gameVersion)
            }

            binding.txtResponse.text = spellsData.toString()

            val spellsDataAsList = spellsData.data.map { it.value }
            val randomSpell = spellsDataAsList.random()
            val imageUrl = randomSpell.image.squareImgUrl



            binding.imgSpell.load("http://ddragon.leagueoflegends.com/cdn/$gameVersion/img/spell/$imageUrl")

        }
    }
}