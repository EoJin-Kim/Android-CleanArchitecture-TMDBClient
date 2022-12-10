package com.ej.tmdbclient.presentation.di.core

import com.ej.tmdbclient.data.api.TMDBService
import com.ej.tmdbclient.data.repository.movie.datasource.ArtistRemoteDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.TvShowRemoteDataSource
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.ArtistRemoteDataSourceImpl
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }
    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }
}