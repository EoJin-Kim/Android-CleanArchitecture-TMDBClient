package com.ej.tmdbclient.presentation.di.artist

import com.ej.tmdbclient.domain.usecase.GetArtistsUseCase
import com.ej.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.ej.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}