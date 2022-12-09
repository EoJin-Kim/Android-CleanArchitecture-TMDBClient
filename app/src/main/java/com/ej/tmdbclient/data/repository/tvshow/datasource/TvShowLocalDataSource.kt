package com.ej.tmdbclient.data.repository.movie.datasource

import com.ej.tmdbclient.data.model.movie.Movie
import com.ej.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(movies:List<TvShow>)
    suspend fun clearAll()
}