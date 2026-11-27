package com.example.kotlin.ui.feature.commerce.data.data_sources.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject


val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name="user_prefs")
class AuthLocalDataSourceImpl @Inject constructor (
    @ApplicationContext private val context: Context
) : AuthLocalDataSource {


    private  val TOKEN_KEY = stringPreferencesKey(name="Token")
private val IS_FIRST_TIME_KEY = booleanPreferencesKey(name="isFirstTime")



    override val tokenFLow: Flow<String?>
        get() = context.dataStore.data

            .catch { exc->
                if(exc is IOException){
                    emit(emptyPreferences())
                }
                else{
                    throw  exc
                }
            }

            .map {
            pref-> pref[TOKEN_KEY]
        }

    override suspend fun saveToken(token: String) {
        context.dataStore.edit {
            pref->
            pref[TOKEN_KEY]=token

        }
    }

    override suspend fun removeToken() {
        context.dataStore.edit {
            pref->
            pref.remove(TOKEN_KEY)


        }
    }

    override val isFirstTime: Flow<Boolean>
        get() = context.dataStore.data.catch {
            exc->
            if(exc is IOException){
                emit(emptyPreferences())
            }
            else{
                throw exc
            }
        }.map {
            pref->pref[IS_FIRST_TIME_KEY] ?: true
        }

    override suspend fun setFirstTimeCompleted() {
        context.dataStore.edit {
            pref->
            pref[IS_FIRST_TIME_KEY]= false
        }
    }


}