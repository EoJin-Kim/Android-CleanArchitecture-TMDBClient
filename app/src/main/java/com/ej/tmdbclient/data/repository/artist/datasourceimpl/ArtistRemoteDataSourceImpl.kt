package com.ej.tmdbclient.data.repository.movie.datasourceimpl

import com.ej.tmdbclient.data.api.TMDBService
import com.ej.tmdbclient.data.model.artist.ArtistList
import com.ej.tmdbclient.data.model.movie.MovieList
import com.ej.tmdbclient.data.repository.movie.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtisits(apiKey)
    }
}