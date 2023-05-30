package com.reylar.testprojectnativeandroid.data.remote.repository

import android.util.Log
import androidx.room.withTransaction
import com.reylar.testprojectnativeandroid.common.Resource
import com.reylar.testprojectnativeandroid.data.db.ButtonEntity
import com.reylar.testprojectnativeandroid.data.db.local.ButtonDatabase
import com.reylar.testprojectnativeandroid.domain.model.ButtonDetail
import com.reylar.testprojectnativeandroid.domain.repo.ButtonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class ButtonRepositoryImpl(
    private val buttonDatabase: ButtonDatabase,
) : ButtonRepository {

    override fun insertData(buttonEntity: ButtonEntity): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())

        try {

            buttonDatabase.withTransaction {
                buttonDatabase.getButtonDao().insertTimeStamp(buttonEntity = buttonEntity)
            }

            emit(Resource.Success(true))

        } catch (error: Exception) {
            emit(Resource.Error(error.localizedMessage ?: "Unable to insert data"))
        }
    }

    override fun getAllData(): Flow<Resource<List<ButtonDetail>>> = flow {
        emit(Resource.Loading())

        try {

            emit(Resource.Success(buttonDatabase.getButtonDao().getAllButtonDetails()))

            Log.d("getProduct","${buttonDatabase.getButtonDao().getAllButtonDetails()}")

        } catch (error: Exception) {
            emit(Resource.Error(error.localizedMessage ?: "Unable to insert data"))
        }
    }

}