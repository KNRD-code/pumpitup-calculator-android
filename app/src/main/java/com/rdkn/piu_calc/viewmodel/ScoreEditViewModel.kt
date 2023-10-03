package com.rdkn.piu_calc.viewmodel

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import com.rdkn.piu_calc.base.BaseViewModel
import com.rdkn.piu_calc.data.Rating
import com.rdkn.piu_calc.data.UserInfo
import io.github.jan.supabase.SupabaseClient

class ScoreEditViewModel(val dbClient: SupabaseClient) : BaseViewModel() {
    var userInfo = MutableLiveData<UserInfo>()
    val rankInfo = ObservableField<Rating>()
    val curScore = ObservableInt(0)

    val ssspCount = ObservableInt(0)
    val sssCount = ObservableInt(0)
    val sspCount = ObservableInt(0)
    val ssCount = ObservableInt(0)
    val spCount = ObservableInt(0)
    val sCount = ObservableInt(0)
    val aaapCount = ObservableInt(0)
    val aaaCount = ObservableInt(0)
    val aapCount = ObservableInt(0)
    val aaCount = ObservableInt(0)
    val apCount = ObservableInt(0)
    val aCount = ObservableInt(0)
}