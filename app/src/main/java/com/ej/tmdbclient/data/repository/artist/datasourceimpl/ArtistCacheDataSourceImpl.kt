package com.ej.tmdbclient.data.repository.movie.datasourceimpl

import com.ej.tmdbclient.data.model.artist.Artist
import com.ej.tmdbclient.data.model.movie.Movie
import com.ej.tmdbclient.data.repository.movie.datasource.ArtisitCacheDataSource

class ArtistCacheDataSourceImpl : ArtisitCacheDataSource {

    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}