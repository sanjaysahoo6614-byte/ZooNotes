package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class BookmarkType {
    NOTE,
    DIAGRAM,
    BOOK
}

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey val itemId: String,
    val type: BookmarkType,
    val paperId: String,
    val paperTitle: String,
    val semester: Int,
    val title: String,
    val subtitle: String,
    val pdfUrl: String? = null,
    val savedAt: Long = System.currentTimeMillis()
)
