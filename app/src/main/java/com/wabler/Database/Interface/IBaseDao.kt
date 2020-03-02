package com.wabler.Database.Interface

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

interface IBaseDao<T> {

    @Insert
    fun insert(obj: T)

    @Insert
    fun insert(vararg obj: T)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)

    @RawQuery
    fun findAll(query: SupportSQLiteQuery): List<T>
}