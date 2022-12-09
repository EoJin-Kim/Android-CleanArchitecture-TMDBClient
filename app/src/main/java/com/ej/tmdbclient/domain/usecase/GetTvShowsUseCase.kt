package com.ej.tmdbclient.domain.usecase

import com.ej.tmdbclient.data.model.tvshow.TvShow
import com.ej.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun excute():List<TvShow>? = tvShowRepository.getTvShows()
}