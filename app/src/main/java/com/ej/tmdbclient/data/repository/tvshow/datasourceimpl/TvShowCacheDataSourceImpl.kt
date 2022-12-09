package com.ej.tmdbclient.data.repository.movie.datasourceimpl

import com.ej.tmdbclient.data.model.movie.Movie
import com.ej.tmdbclient.data.model.tvshow.TvShow
import com.ej.tmdbclient.data.repository.movie.datasource.ArtisitCacheDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}