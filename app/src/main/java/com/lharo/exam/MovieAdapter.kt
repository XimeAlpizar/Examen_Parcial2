package com.lharo.exam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(context: Context, movieModel: ArrayList<MovieModel>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<MovieModel>? = null

    init {
        localContext = context
        localFeedEntries = movieModel
    }

    //Inflar el layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)//Referencia al MainActivity
        val view: View = layoutInflater.inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    //Asignar valores a las filas cuando son reintroducidas a la pantalla en la posición que tienen en la vista
    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val currentFeed: MovieModel = localFeedEntries!![position]
        holder.textTitle.text = currentFeed.title
        holder.textMetascore.text = currentFeed.metascore
        holder.textRating.text = currentFeed.imdbRating
        holder.textImdbVotes.text = currentFeed.imdbVotes
    }

    override fun getItemCount(): Int {
        return localFeedEntries?.size ?: 0
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v){

        val textTitle: TextView = v.findViewById(R.id.movie_title)
        val textMetascore: TextView = v.findViewById(R.id.Metascore)
        val textRating: TextView = v.findViewById(R.id.rating)
        val textImdbVotes: TextView = v.findViewById(R.id.ImdbVotes)

    }
}