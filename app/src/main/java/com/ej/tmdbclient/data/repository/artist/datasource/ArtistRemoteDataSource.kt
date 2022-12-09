package com.ej.tmdbclient.data.repository.movie.datasource

import com.ej.tmdbclient.data.model.artist.ArtistList
import com.ej.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}