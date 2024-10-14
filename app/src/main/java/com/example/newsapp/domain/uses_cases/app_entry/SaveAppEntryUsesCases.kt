package com.example.newsapp.domain.uses_cases.app_entry

import com.example.newsapp.domain.manger.LocalUserManger

class SaveAppEntryUsesCases (
    private val localUserManger: LocalUserManger
){
    suspend  operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}