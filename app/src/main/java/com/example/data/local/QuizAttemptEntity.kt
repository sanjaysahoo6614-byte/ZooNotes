package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_attempts")
data class QuizAttemptEntity(
    @PrimaryKey val chapterId: String,
    val bestScore: Int,
    val totalQuestions: Int,
    val lastAttemptedAt: Long = System.currentTimeMillis()
)
