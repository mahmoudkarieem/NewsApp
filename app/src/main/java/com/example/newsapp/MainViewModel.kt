package com.example.newsapp

import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.uses_cases.AppEntryUsesCases
import javax.inject.Inject


class MainViewModel@Inject constructor(
    private val appEntryUsesCases: AppEntryUsesCases

):ViewModel (){
}