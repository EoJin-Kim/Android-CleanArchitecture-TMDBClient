package com.ej.tmdbclient.data.repository.movie.datasourceimpl

import android.util.Log
import com.ej.tmdbclient.data.model.movie.Movie
import com.ej.tmdbclient.data.model.tvshow.TvShow
import com.ej.tmdbclient.data.repository.movie.datasource.*
import com.ej.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource,
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }

        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()

        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}