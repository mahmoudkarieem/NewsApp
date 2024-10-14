package com.example.newsapp.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsapp.utli.Utils.APP_ENTRY
import com.example.newsapp.utli.Utils.USER_SETTINGS
import com.example.newsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserMangerImp(
    private val context: Context
) : LocalUserManger {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.App_Entry] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.App_Entry] ?: false

        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)


object PreferencesKeys {
    val App_Entry = booleanPreferencesKey(name = APP_ENTRY)

}