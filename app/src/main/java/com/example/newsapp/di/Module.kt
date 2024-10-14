package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.data.manger.LocalUserMangerImp
import com.example.newsapp.domain.manger.LocalUserManger
import com.example.newsapp.domain.uses_cases.app_entry.AppEntryUsesCases
import com.example.newsapp.domain.uses_cases.app_entry.ReadAppEntryUsesCases
import com.example.newsapp.domain.uses_cases.app_entry.SaveAppEntryUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImp(application)

    @Provides
    @Singleton
    fun provideAppEntryUsesCases(
        localUserManger: LocalUserManger
    ) = AppEntryUsesCases(
        readAppEntryUsesCases = ReadAppEntryUsesCases(localUserManger),
        saveAppEntryUsesCases = SaveAppEntryUsesCases(localUserManger)
    )

}