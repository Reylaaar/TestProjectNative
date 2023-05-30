package com.reylar.testprojectnativeandroid.presentation.home.dashboard

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reylar.testprojectnativeandroid.common.Resource
import com.reylar.testprojectnativeandroid.common.helper.DateHelper
import com.reylar.testprojectnativeandroid.data.db.ButtonEntity
import com.reylar.testprojectnativeandroid.domain.repo.ButtonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val buttonRepository: ButtonRepository,
) : ViewModel() {

    val button1 by mutableStateOf("button1")
    val button2 by mutableStateOf("button2")
    val button3 by mutableStateOf("button3")
    val button4 by mutableStateOf("button4")


    fun insertButtonDetail(buttonName: String) {

        val btnEntity = ButtonEntity(
            buttonName = buttonName,
            pressTime = DateHelper.currentTime(Calendar.getInstance().time)
        )

        buttonRepository.insertData(buttonEntity = btnEntity).onEach { response ->
            when (response) {
                is Resource.Error -> {

                }

                is Resource.Loading -> {

                }

                is Resource.Success -> {
                    Log.d("ButtonDao", "Inserted Successfully")
                }
            }
        }.launchIn(viewModelScope)
    }

}