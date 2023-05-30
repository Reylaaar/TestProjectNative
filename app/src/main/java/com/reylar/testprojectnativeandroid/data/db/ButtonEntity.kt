package com.reylar.testprojectnativeandroid.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buttons")
data class ButtonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val buttonName: String,
    val pressTime: String,
)