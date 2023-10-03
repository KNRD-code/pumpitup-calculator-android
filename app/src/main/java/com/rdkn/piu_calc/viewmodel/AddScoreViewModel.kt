package com.rdkn.piu_calc.viewmodel

import androidx.databinding.ObservableField
import com.rdkn.piu_calc.base.BaseViewModel
import com.rdkn.piu_calc.common.DBConst
import com.rdkn.piu_calc.data.Song
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest

/**
 * {File Description}
 * created by KANA (2023-10-03)
 */
class AddScoreViewModel(val dbClient: SupabaseClient) : BaseViewModel() {
    val songInfo = ObservableField(Song())

    suspend fun getAllSong() {
        dbClient.postgrest[DBConst.TABLE_NAME_SONG]
    }
}