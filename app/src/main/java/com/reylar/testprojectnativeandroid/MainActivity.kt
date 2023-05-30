package com.reylar.testprojectnativeandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.reylar.testprojectnativeandroid.common.localNavController
import com.reylar.testprojectnativeandroid.common.localNavDashboardViewModel
import com.reylar.testprojectnativeandroid.common.localNavInfoViewModelViewModel
import com.reylar.testprojectnativeandroid.presentation.home.HomeScreen
import com.reylar.testprojectnativeandroid.presentation.home.Screen
import com.reylar.testprojectnativeandroid.presentation.home.dashboard.DashboardScreen
import com.reylar.testprojectnativeandroid.presentation.home.dashboard.DashboardViewModel
import com.reylar.testprojectnativeandroid.presentation.home.info.InfoScreen
import com.reylar.testprojectnativeandroid.presentation.home.info.InfoViewModel
import com.reylar.testprojectnativeandroid.ui.theme.TestProjectNativeAndroidTheme
import dagger.hilt.android.AndroidEntryPoint


@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val mainNavController = rememberAnimatedNavController()


            val dashboardViewModel: DashboardViewModel = hiltViewModel()
            val infoViewModel: InfoViewModel = hiltViewModel()

            TestProjectNativeAndroidTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompositionLocalProvider(
                        localNavController provides mainNavController,
                        localNavDashboardViewModel provides dashboardViewModel,
                        localNavInfoViewModelViewModel provides infoViewModel
                    ) {
                        NavHost(
                            navController = mainNavController,
                            startDestination = Screen.home.route
                        ) {

                            composable(route = Screen.dashboard.route){
                                DashboardScreen()
                            }

                            composable(route = Screen.info.route){
                                InfoScreen()
                            }

                            composable(route = Screen.home.route){
                                HomeScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
