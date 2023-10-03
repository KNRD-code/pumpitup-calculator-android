package com.rdkn.piu_calc.viewmodel

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import com.rdkn.piu_calc.base.BaseViewModel
import com.rdkn.piu_calc.data.Rating
import com.rdkn.piu_calc.data.UserInfo

class MainViewModel : BaseViewModel() {
    var userInfo = MutableLiveData<UserInfo>()
    val ratingInfo = ObservableField<Rating>()

    // UserInfo ObservableData
    val title = ObservableField<String>()
    val tLevel = ObservableInt(0)

}