package com.reylar.testprojectnativeandroid.presentation.home.info

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reylar.testprojectnativeandroid.common.Resource
import com.reylar.testprojectnativeandroid.domain.repo.ButtonRepository
import com.reylar.testprojectnativeandroid.presentation.home.info.state.ButtonsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val buttonRepository: ButtonRepository,
) : ViewModel() {

    private val _buttonsState = MutableStateFlow(ButtonsState())
    val buttonsState = _buttonsState


    fun getButtonsDetail(){

        buttonRepository.getAllData().onEach { response ->
            when(response){
                is Resource.Error -> {
                    _buttonsState.value = _buttonsState.value.copy(
                        isLoading = false,
                        errorMessage = "${response.message}"
                    )
                }
                is Resource.Loading -> {
                    _buttonsState.value = _buttonsState.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {

                    response.data?.let {buttonsDetail ->
                        _buttonsState.value = _buttonsState.value.copy(
                            buttonDetails = buttonsDetail,
                            isLoading = false
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}