package com.ej.tmdbclient.presentation.di.core

import com.ej.tmdbclient.data.repository.movie.datasource.*
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.ArtistRepositoryImpl
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.MovieRepositoryImpl
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.TvShowRepositoryImpl
import com.ej.tmdbclient.domain.repository.ArtistRepository
import com.ej.tmdbclient.domain.repository.MovieRepository
import com.ej.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShoRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ) : TvShowRepository{
        return TvShowRepositoryImpl(
            tvShoRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
    ) : ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource,
        )
    }
}