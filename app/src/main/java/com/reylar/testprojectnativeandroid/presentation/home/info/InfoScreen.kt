package com.reylar.testprojectnativeandroid.presentation.home.info

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.reylar.testprojectnativeandroid.domain.model.ButtonDetail
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(
    infoViewModel: InfoViewModel = hiltViewModel(),
) {

    val scrollState = rememberLazyListState()
    val state = infoViewModel.buttonsState.collectAsState().value
    val scope = rememberCoroutineScope()

    var initialLoad by remember {
        mutableStateOf(true)
    }

    if (initialLoad) {
        LaunchedEffect(key1 = Unit) {
            infoViewModel.getButtonsDetail()
            initialLoad = false
        }
    }

    Scaffold(topBar = {

    },
        content = { paddingValues ->

            LazyColumn(
                modifier = Modifier
                    .padding(
                        horizontal = 12.dp,
                        vertical = 10.dp
                    )
                    .fillMaxSize(),
                contentPadding = paddingValues,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    items(
                        items = state.buttonDetails,
                        key = { event ->
                            event.id
                        },
                    ) { buttonDetail ->
                        ButtonDetailItem(buttonDetail = buttonDetail)
                    }
                },
                state = scrollState
            )
        }
    )
}


@Composable
fun ButtonDetailItem(buttonDetail: ButtonDetail) {

    Column(modifier = Modifier.border(1.dp, Color.Gray)) {

        Text(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 8.dp),
            text = "${buttonDetail.buttonName} pressed",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp,
            ),
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 8.dp),
            text = buttonDetail.pressTime,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp,
            ),
        )
    }
}