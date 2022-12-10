package com.ej.tmdbclient.presentation.di

import com.ej.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.ej.tmdbclient.presentation.di.movie.MovieSubComponent
import com.ej.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}