package com.example.newsapp.presentation.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsapp.presentation.Dimens.MediumPadding2
import com.example.newsapp.presentation.common_component.NewsButton
import com.example.newsapp.presentation.common_component.TextNewsButton
import com.example.newsapp.presentation.screens.onboarding.component.OnBoarding
import com.example.newsapp.presentation.screens.onboarding.component.PageIndicator
import com.example.newsapp.presentation.screens.onboarding.model.pages
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size

        }
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started ")
                    else -> listOf("", "")

                }
            }
        }
        HorizontalPager(state = pagerState) { index ->
            OnBoarding(pageModel = pages[index])

        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    horizontal = MediumPadding2
                )
                .fillMaxWidth()
                .navigationBarsPadding()
        ) {
            PageIndicator(
                modifier = Modifier.width(52.dp),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    TextNewsButton(textButton = buttonState.value[0], onClickButtonText = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }

                    }
                    )
                }
                NewsButton(textButton = buttonState.value[1],
                    onClickButton = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                // TODO: Navigate yo Home Screen


                            } else {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )


            }


        }
        Spacer(modifier = Modifier.weight(0.5f))
    }

}