package com.rdkn.piu_calc.activity

import com.rdkn.piu_calc.R
import com.rdkn.piu_calc.base.BaseActivity
import com.rdkn.piu_calc.databinding.ActivityAddScoreBinding
import com.rdkn.piu_calc.viewmodel.AddScoreViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 스코어 추가 화면
 * created by KANA (2023-10-03)
 */
class AddScoreActivity : BaseActivity<ActivityAddScoreBinding>() {
    override var layoutRes: Int = R.layout.activity_add_score
    val viewModel: AddScoreViewModel by viewModel()

    override fun init() {
    }
}