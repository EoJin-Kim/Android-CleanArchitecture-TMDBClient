package com.ej.tmdbclient.data.repository.movie.datasourceimpl

import com.ej.tmdbclient.data.api.TMDBService
import com.ej.tmdbclient.data.model.movie.MovieList
import com.ej.tmdbclient.data.model.tvshow.TvShow
import com.ej.tmdbclient.data.model.tvshow.TvShowList
import com.ej.tmdbclient.data.repository.movie.datasource.ArtistRemoteDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}