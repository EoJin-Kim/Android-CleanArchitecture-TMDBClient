package com.ej.tmdbclient.data.repository.movie.datasource

import com.ej.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}