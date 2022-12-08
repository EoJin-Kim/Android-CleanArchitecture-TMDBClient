package com.ej.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ej.tmdbclient.data.model.artist.Artist
import com.ej.tmdbclient.data.model.movie.Movie
import com.ej.tmdbclient.data.model.tvshow.TvShow


@Database(entities = [Movie::class,TvShow::class,Artist::class],
    version = 1,
    exportSchema = false
    )
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}