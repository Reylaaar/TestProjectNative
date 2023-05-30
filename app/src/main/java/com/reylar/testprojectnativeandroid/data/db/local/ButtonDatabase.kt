package com.reylar.testprojectnativeandroid.data.db.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.reylar.testprojectnativeandroid.data.db.ButtonEntity
import com.reylar.testprojectnativeandroid.data.db.RemoteKeys

@Database(entities = [ButtonEntity::class,RemoteKeys::class], version = 1)
abstract class ButtonDatabase : RoomDatabase() {
    abstract fun getButtonDao() : ButtonDao
    abstract fun getRemoteKeysDao(): RemoteKeysDao
}