package com.reylar.testprojectnativeandroid.data.db.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reylar.testprojectnativeandroid.data.db.ButtonEntity
import com.reylar.testprojectnativeandroid.domain.model.ButtonDetail
import kotlinx.coroutines.flow.Flow

@Dao
interface ButtonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimeStamp(buttonEntity: ButtonEntity)

    @Query("Select * FROM buttons")
    suspend fun getAllButtonDetails() : List<ButtonDetail>
}