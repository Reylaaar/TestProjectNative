package com.reylar.testprojectnativeandroid.presentation.home.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel = hiltViewModel(),
) {

    Scaffold(topBar = {

    },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(onClick = {
                        dashboardViewModel.insertButtonDetail(dashboardViewModel.button1)
                    }) {
                        Text(text = dashboardViewModel.button1)
                    }

                    Button(onClick = {
                        dashboardViewModel.insertButtonDetail(dashboardViewModel.button2)
                    }) {
                        Text(text = dashboardViewModel.button2)
                    }

                    Button(onClick = {
                        dashboardViewModel.insertButtonDetail(dashboardViewModel.button3)
                    }) {
                        Text(text = dashboardViewModel.button3)
                    }

                    Button(onClick = {
                        dashboardViewModel.insertButtonDetail(dashboardViewModel.button4)
                    }) {
                        Text(text = dashboardViewModel.button4)
                    }
                }
            }
        }
    )
}