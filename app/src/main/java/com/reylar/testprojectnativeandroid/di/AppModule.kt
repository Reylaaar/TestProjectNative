package com.reylar.testprojectnativeandroid.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reylar.testprojectnativeandroid.data.db.local.ButtonDao
import com.reylar.testprojectnativeandroid.data.db.local.ButtonDatabase
import com.reylar.testprojectnativeandroid.data.db.local.RemoteKeysDao
import com.reylar.testprojectnativeandroid.data.remote.repository.ButtonRepositoryImpl
import com.reylar.testprojectnativeandroid.domain.repo.ButtonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideButtonDatabase(@ApplicationContext context: Context): ButtonDatabase {
        return Room.databaseBuilder(
            context = context,
            ButtonDatabase::class.java,
            "button_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideButtonDao(buttonDatabase: ButtonDatabase): ButtonDao =
        buttonDatabase.getButtonDao()

    @Singleton
    @Provides
    fun provideRemoteKeysDao(buttonDatabase: ButtonDatabase): RemoteKeysDao =
        buttonDatabase.getRemoteKeysDao()

    @Singleton
    @Provides
    fun provideButtonRepository(
        buttonDatabase: ButtonDatabase,
    ): ButtonRepository {
        return ButtonRepositoryImpl(buttonDatabase = buttonDatabase)
    }
}