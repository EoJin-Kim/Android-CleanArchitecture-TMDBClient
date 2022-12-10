package com.ej.tmdbclient.presentation.di.tvshow

import com.ej.tmdbclient.domain.usecase.*
import com.ej.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.ej.tmdbclient.presentation.movie.MovieViewModelFactory
import com.ej.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ):TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}