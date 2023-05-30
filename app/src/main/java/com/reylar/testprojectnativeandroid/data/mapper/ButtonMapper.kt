package com.reylar.testprojectnativeandroid.data.mapper

import com.reylar.testprojectnativeandroid.data.db.ButtonEntity
import com.reylar.testprojectnativeandroid.domain.model.ButtonDetail

fun ButtonEntity.toButtonDetail(): ButtonDetail {
    return ButtonDetail(
        id = id,
        buttonName = buttonName,
        pressTime = pressTime
    )
}

