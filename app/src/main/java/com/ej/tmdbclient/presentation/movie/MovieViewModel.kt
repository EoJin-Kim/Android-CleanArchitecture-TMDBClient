package com.ej.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ej.tmdbclient.domain.usecase.GetMoviesUseCase
import com.ej.tmdbclient.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUsecase: UpdateMoviesUsecase,
) :ViewModel(){

    fun getMovies() = liveData{
        val moveList = getMoviesUseCase.excute()
        emit(moveList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.excute()
        emit(movieList)
    }
}