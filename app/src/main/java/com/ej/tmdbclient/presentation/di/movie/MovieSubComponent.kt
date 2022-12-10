package com.ej.tmdbclient.presentation.di.movie

import com.ej.tmdbclient.presentation.artist.ArtistActivity
import com.ej.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [
    MovieModule::class
])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}