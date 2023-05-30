package com.reylar.testprojectnativeandroid.test

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.reylar.testprojectnativeandroid.common.helper.DateHelper
import com.reylar.testprojectnativeandroid.data.db.ButtonEntity
import com.reylar.testprojectnativeandroid.data.db.local.ButtonDao
import com.reylar.testprojectnativeandroid.data.db.local.ButtonDatabase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Calendar

class RoomInfoDatabaseTest {

    private lateinit var buttonDao: ButtonDao
    private lateinit var buttonDatabase: ButtonDatabase

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        buttonDatabase =
            Room.inMemoryDatabaseBuilder(context = context, ButtonDatabase::class.java).build()
        buttonDao = buttonDatabase.getButtonDao()
    }

    @After
    fun close() {
        buttonDatabase.close()
    }

    @Test
    fun button_is_Pressed() = runTest {
        val buttonEntity = ButtonEntity(
            buttonName = "button1", pressTime = DateHelper.currentTime(
                Calendar.getInstance().time
            )
        )

        //Insert
        buttonDao.insertTimeStamp(buttonEntity = buttonEntity)

        //Select
        val buttonList = buttonDao.getAllButtonDetails()

        assertEquals(1,buttonList.size)
        assertEquals("button1",buttonList[0].buttonName)
    }


}