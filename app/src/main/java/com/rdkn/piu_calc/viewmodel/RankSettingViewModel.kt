package com.rdkn.piu_calc.viewmodel

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.rdkn.piu_calc.base.BaseViewModel
import com.rdkn.piu_calc.data.Rating
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest

class RankSettingViewModel : BaseViewModel() {
    val rTitle = ObservableField<String>() // E: EXPERT, A: ADVANCED, I: INTERMEDIATE, B: BEGINNER
    val rLevel = ObservableInt(0) // 1~10
}