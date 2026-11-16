package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.curriculum.ZoologyCurriculumRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("ZooNotes", appName)
    }

    @Test
    fun `curriculum spans semesters 1 to 6 and supports search`() {
        assertEquals(6, ZoologyCurriculumRepository.semesters.size)
        assertTrue(ZoologyCurriculumRepository.allPapers.size >= 10)
        assertTrue(ZoologyCurriculumRepository.search("Krebs").isNotEmpty())
        assertTrue(ZoologyCurriculumRepository.search("Kotpal").isNotEmpty())
        assertTrue(ZoologyCurriculumRepository.search("Lehninger").isNotEmpty())
        assertTrue(ZoologyCurriculumRepository.search("Guyton").isNotEmpty())
    }
}
