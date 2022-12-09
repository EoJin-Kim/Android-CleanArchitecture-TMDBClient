package com.ej.tmdbclient.domain.repository

import com.ej.tmdbclient.data.db.MovieDao
import com.ej.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}