package com.rdkn.piu_calc.common

import com.rdkn.piu_calc.viewmodel.AddScoreViewModel
import com.rdkn.piu_calc.viewmodel.MainViewModel
import com.rdkn.piu_calc.viewmodel.RankSettingViewModel
import com.rdkn.piu_calc.viewmodel.ScoreEditViewModel
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    factory {
        createSupabaseClient(
            "https://xefjhykbgtkcikmlfleo.supabase.co",
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InhlZmpoeWtiZ3RrY2lrbWxmbGVvIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTMyMDY5MjgsImV4cCI6MjAwODc4MjkyOH0.9n8lAqxTAzeOoD7NnBFoHJNrfvuo1Z3qcDC3VoFGxUo"
        ) {
            install(Postgrest)
        }
    }
}

val vmModule = module {
    viewModel { MainViewModel() }
    viewModel { RankSettingViewModel() }
    viewModel { ScoreEditViewModel(get()) }
    viewModel { AddScoreViewModel(get()) }
}