package com.reylar.testprojectnativeandroid.common

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import com.reylar.testprojectnativeandroid.presentation.home.dashboard.DashboardViewModel
import com.reylar.testprojectnativeandroid.presentation.home.info.InfoViewModel


val localNavController =
    compositionLocalOf<NavHostController> {  error("No localNavController found!") }

val localNavDashboardViewModel =
    compositionLocalOf<DashboardViewModel> { error("No DashboardViewModel found!") }

val localNavInfoViewModelViewModel =
    compositionLocalOf<InfoViewModel> { error("No InfoViewModel found!") }