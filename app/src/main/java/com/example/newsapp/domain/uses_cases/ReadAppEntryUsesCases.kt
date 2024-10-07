package com.example.newsapp.domain.uses_cases

import com.example.newsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUsesCases(
    private val localUserManger: LocalUserManger
) {
      operator fun invoke() :Flow<Boolean>{
         return localUserManger.readAppEntry()
    }


}