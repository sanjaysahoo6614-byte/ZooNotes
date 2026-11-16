package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

class ZooNotesConverters {
    @TypeConverter
    fun fromBookmarkType(type: BookmarkType): String = type.name

    @TypeConverter
    fun toBookmarkType(value: String): BookmarkType = BookmarkType.valueOf(value)
}

@Database(
    entities = [BookmarkEntity::class, QuizAttemptEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ZooNotesConverters::class)
abstract class ZooNotesDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun quizAttemptDao(): QuizAttemptDao

    companion object {
        @Volatile
        private var INSTANCE: ZooNotesDatabase? = null

        fun getInstance(context: Context): ZooNotesDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ZooNotesDatabase::class.java,
                    "zoonotes_offline.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
