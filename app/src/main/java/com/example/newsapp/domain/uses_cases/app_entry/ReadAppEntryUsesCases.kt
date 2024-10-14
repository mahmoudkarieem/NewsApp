package com.example.newsapp.domain.uses_cases.app_entry

import com.example.newsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUsesCases(
    private val localUserManger: LocalUserManger
) {
      operator fun invoke() :Flow<Boolean>{
         return localUserManger.readAppEntry()
    }


}