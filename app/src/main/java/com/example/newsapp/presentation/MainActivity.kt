package com.example.newsapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.domain.uses_cases.AppEntryUsesCases
import com.example.newsapp.presentation.screens.onboarding.OnBoardingScreen
import com.example.newsapp.presentation.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUsesCases: AppEntryUsesCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            appEntryUsesCases.readAppEntryUsesCases().collect() {
                Log.d("Te", it.toString())
            }
        }
        installSplashScreen()
        setContent {
            NewsAppTheme {
                Box(
                    modifier = Modifier.background
                        (color = MaterialTheme.colorScheme.background)
                ) {
                    OnBoardingScreen()
                }
            }
        }
    }


}

