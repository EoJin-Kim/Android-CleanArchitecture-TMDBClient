package com.ej.tmdbclient.data.repository.movie.datasourceimpl

import android.util.Log
import com.ej.tmdbclient.data.model.artist.Artist
import com.ej.tmdbclient.data.repository.movie.datasource.ArtistCacheDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.ArtistLocalDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.ArtistRemoteDataSource
import com.ej.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artCacheDataSource: ArtistCacheDataSource,
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getMoviesFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }

        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var movieList : List<Artist>
        try {
            movieList = artistLocalDataSource.getArtistFromDB()

        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Artist> {
        lateinit var artistList : List<Artist>
        try {
            artistList = artCacheDataSource.getArtistsFromCache()

        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}