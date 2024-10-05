package com.example.newsapp.presentation.screens.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.newsapp.presentation.screens.onboarding.component.OnBoarding
import com.example.newsapp.presentation.screens.onboarding.model.pages

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size

        }
        val buttonState= remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0-> listOf("","Next")
                    1-> listOf("Back","Next")
                    2-> listOf("Back","Get Started ")
                    else -> listOf("","")

                }
            }
        }
        HorizontalPager(state = pagerState) {index->
            OnBoarding(pageModel =pages[index] )

        }

    }

}