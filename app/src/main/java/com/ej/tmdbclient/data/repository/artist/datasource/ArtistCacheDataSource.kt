package com.ej.tmdbclient.data.repository.movie.datasource

import com.ej.tmdbclient.data.model.artist.Artist
import com.ej.tmdbclient.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(movies:List<Artist> )

}