package com.example.newsapp.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.uses_cases.app_entry.AppEntryUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    val appEntryUsesCases: AppEntryUsesCases

) : ViewModel() {
    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()

            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUsesCases.saveAppEntryUsesCases()
        }
    }
}