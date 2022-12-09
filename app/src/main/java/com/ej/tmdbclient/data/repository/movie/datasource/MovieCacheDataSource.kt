package com.ej.tmdbclient.data.repository.movie.datasource

import com.ej.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie> )

}