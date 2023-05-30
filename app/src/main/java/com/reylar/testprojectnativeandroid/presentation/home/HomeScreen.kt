package com.reylar.testprojectnativeandroid.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.reylar.testprojectnativeandroid.domain.model.TabPage
import com.reylar.testprojectnativeandroid.presentation.common.CustomTab
import com.reylar.testprojectnativeandroid.presentation.home.dashboard.DashboardScreen
import com.reylar.testprojectnativeandroid.presentation.home.info.InfoScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    val tabs: List<TabPage> = listOf(
        TabPage(
            content = {
                DashboardScreen()
            },
            type = "Dashboard"
        ),
        TabPage(
            content = {
                InfoScreen()
            },
            type = "Info"
        )
    )

    Column {
        TabRow(
            modifier = Modifier.padding(horizontal = 14.dp),
            selectedTabIndex = pagerState.currentPage,
            contentColor = Color.White,
            containerColor = Color.White,
            indicator = { tabPositions ->
                Box {}
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                CustomTab(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(40.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(
                            color = if (pagerState.currentPage == index) Color(0xFFBB86FC) else Color(
                                0xFFF7FAFC
                            )
                        ),
                    tab = tab.type, isSelected = pagerState.currentPage == index,
                    selectedColor = Color.White,
                    onSelectTab = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            count = tabs.size,
        ) { page ->
            tabs[page].content.invoke()
        }
    }
}