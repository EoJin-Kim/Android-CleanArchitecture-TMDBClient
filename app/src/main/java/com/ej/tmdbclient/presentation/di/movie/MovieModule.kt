package com.ej.tmdbclient.presentation.di.movie

import com.ej.tmdbclient.domain.usecase.GetArtistsUseCase
import com.ej.tmdbclient.domain.usecase.GetMoviesUseCase
import com.ej.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.ej.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.ej.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.ej.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }
}