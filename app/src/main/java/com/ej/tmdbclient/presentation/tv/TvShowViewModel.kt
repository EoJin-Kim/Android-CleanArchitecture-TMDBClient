package com.ej.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ej.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.ej.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.excute()
        emit(tvShowList)
    }

    fun updateTvshows() = liveData {
        val tvShowList = updateTvShowsUseCase.excute()
        emit(tvShowList)
    }
}