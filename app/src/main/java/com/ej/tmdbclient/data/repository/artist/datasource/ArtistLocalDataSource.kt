package com.ej.tmdbclient.data.repository.movie.datasource

import com.ej.tmdbclient.data.model.artist.Artist
import com.ej.tmdbclient.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB():List<Artist>
    suspend fun saveArtistsToDB(movies:List<Artist>)
    suspend fun clearAll()
}