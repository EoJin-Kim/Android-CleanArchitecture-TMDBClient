package com.ej.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ej.tmdbclient.domain.usecase.GetArtistsUseCase
import com.ej.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.excute()
        emit(artistList)
    }
    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.excute()
        emit(artistList)
    }
}