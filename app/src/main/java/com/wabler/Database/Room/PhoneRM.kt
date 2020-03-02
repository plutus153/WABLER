package com.wabler.Database.Room

import android.content.Context
import androidx.room.*
import com.wabler.Database.Entities.*
import com.wabler.Database.Interface.*

@Database(entities = [Phone::class], version = DATABASE_VERSION, exportSchema = false)
abstract class PhoneRM: BaseRoomDatabase(){
    abstract fun Service(): IPhoneService

    companion object {
        @Volatile
        private var INSTANCE: Any? = null

        fun getDatabase(context: Context, kClass: Any, tableName: String): Any {
            return INSTANCE ?: synchronized(this){
                val instance = Build(
                    context.applicationContext,
                    InitClass(kClass),
                    tableName)
                INSTANCE = instance
                instance
            }
        }
    }
}
