package com.richmondprojects.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ResultsEntity::class], version = 1, exportSchema = false)
abstract class StarDatabase : RoomDatabase() {

    abstract val dao: ResultsDao
}