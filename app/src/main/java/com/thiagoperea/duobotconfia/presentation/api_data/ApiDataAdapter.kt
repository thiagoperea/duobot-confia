package com.thiagoperea.duobotconfia.presentation.api_data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.thiagoperea.duobotconfia.R
import com.thiagoperea.duobotconfia.data.model.Champion

class ApiDataAdapter : RecyclerView.Adapter<ApiDataViewHolder>() {

    private var gameVersion = ""
    private val dataset = mutableListOf<Champion>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_api_data, parent, false)

        return ApiDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiDataViewHolder, position: Int) {
        val championData = dataset[position]

        holder.bind(championData, gameVersion)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun replaceData(newData: List<Champion>, gameVersion: String) {
        dataset.clear()
        dataset.addAll(newData)
        this.gameVersion = gameVersion

        notifyDataSetChanged()
    }
}

class ApiDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(championData: Champion, gameVersion: String) {
        itemView.findViewById<TextView>(R.id.txtChampionName).text = championData.name

        itemView.findViewById<TextView>(R.id.txtChampionTags).text = championData.roles.toString()

        val imageView = itemView.findViewById<ImageView>(R.id.ivChampionArt)

        imageView.load("http://ddragon.leagueoflegends.com/cdn/${gameVersion}/img/champion/${championData.image.full}") {
            crossfade(true)
//            placeholder(R.drawable.image)
            transformations(CircleCropTransformation())
        }
    }
}

