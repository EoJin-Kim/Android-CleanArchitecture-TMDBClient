package com.ej.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ej.tmdbclient.R
import com.ej.tmdbclient.data.model.movie.Movie
import com.ej.tmdbclient.databinding.ListItemBinding

class MovieAdapter :RecyclerView.Adapter<MoviewViewHolder>(){
    private val movieList = ArrayList<Movie>()

    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding= DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MoviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviewViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MoviewViewHolder(val binding :ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(movie:Movie){
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }
}