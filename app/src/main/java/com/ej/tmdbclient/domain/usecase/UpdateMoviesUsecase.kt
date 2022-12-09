package com.ej.tmdbclient.domain.usecase

import com.ej.tmdbclient.data.model.movie.Movie
import com.ej.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun excute():List<Movie>? = movieRepository.updateMovies()
}