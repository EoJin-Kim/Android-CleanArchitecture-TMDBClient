package com.ej.tmdbclient.presentation.di.tvshow

import com.ej.tmdbclient.presentation.artist.ArtistActivity
import com.ej.tmdbclient.presentation.movie.MovieActivity
import com.ej.tmdbclient.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [
    TvShowModule::class
])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}