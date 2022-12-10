package com.ej.tmdbclient.presentation.di.core

import com.ej.tmdbclient.data.repository.movie.datasource.ArtistCacheDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.ej.tmdbclient.data.repository.movie.datasource.TvShowCacheDataSource
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.ArtistCacheDataSourceImpl
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.ej.tmdbclient.data.repository.movie.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
}