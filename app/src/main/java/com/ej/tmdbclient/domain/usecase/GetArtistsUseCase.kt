package com.ej.tmdbclient.domain.usecase

import com.ej.tmdbclient.data.model.artist.Artist
import com.ej.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun excute():List<Artist>?= artistRepository.getArtists()
}