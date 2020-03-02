package com.wabler.Database.Room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

const val DATABASE_VERSION: Int = 1

abstract class BaseRoomDatabase: RoomDatabase() {

    companion object {
        fun <T> InitClass(obj: Any): Class<T> {
            return obj as Class<T>
        }

        // Migration path definition from version 2 to version 3.
        val MIGRATION = object : Migration(6, 7) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }

        //https://developer.android.com/training/data-storage/room/prepopulate

        fun <T: RoomDatabase> Build(context: Context, klass: Class<T>, name: String): T {
            return Room.databaseBuilder(context.applicationContext, klass, name
            )
                //.createFromAsset("database/myapp.db")
                //.addMigrations(MIGRATION)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                //.addCallback(StudentDatabaseCallback(scope))

                .build()
        }
    }
}