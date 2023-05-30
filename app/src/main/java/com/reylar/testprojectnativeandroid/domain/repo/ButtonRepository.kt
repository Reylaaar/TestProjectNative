package com.reylar.testprojectnativeandroid.domain.repo

import com.reylar.testprojectnativeandroid.common.Resource
import com.reylar.testprojectnativeandroid.data.db.ButtonEntity
import com.reylar.testprojectnativeandroid.domain.model.ButtonDetail
import kotlinx.coroutines.flow.Flow

interface ButtonRepository {

     fun insertData(buttonEntity: ButtonEntity) : Flow<Resource<Boolean>>

     fun getAllData(): Flow<Resource<List<ButtonDetail>>>
}