package com.reylar.testprojectnativeandroid.presentation.home.info.state

import com.reylar.testprojectnativeandroid.domain.model.ButtonDetail

data class ButtonsState(
    val buttonDetails: List<ButtonDetail> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)