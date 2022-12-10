package com.ej.tmdbclient.presentation.di.core

import android.content.Context
import com.ej.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.ej.tmdbclient.presentation.di.movie.MovieSubComponent
import com.ej.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(subcomponents = [
    MovieSubComponent::class,
    TvShowSubComponent::class,
    ArtistSubComponent::class,
])
class AppModule(private val contenxt:Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return contenxt.applicationContext
    }
}