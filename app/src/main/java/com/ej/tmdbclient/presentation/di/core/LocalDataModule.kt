package com.ej.tmdbclient.presentation.di.core

import com.ej.tmdbclient.data.db.ArtistDao
import com.ej.tmdbclient.data.db.MovieDao
import com.ej.tmdbclient.data.db.TvShowDao
import com.ej.tmdbclient.data.repository.movie.datasource.ArtistLocalDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.TvShowLocalDataSource
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.ArtistLocalDataSourceImpl
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }
}