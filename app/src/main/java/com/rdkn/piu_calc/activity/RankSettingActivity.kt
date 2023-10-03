package com.rdkn.piu_calc.activity

import android.content.Intent
import com.rdkn.piu_calc.R
import com.rdkn.piu_calc.adapter.RankLevelAdapter
import com.rdkn.piu_calc.base.BaseActivity
import com.rdkn.piu_calc.common.*
import com.rdkn.piu_calc.databinding.ActivityRankSettingBinding
import com.rdkn.piu_calc.viewmodel.RankSettingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RankSettingActivity : BaseActivity<ActivityRankSettingBinding>() {
    override var layoutRes: Int = R.layout.activity_rank_setting
    private val viewModel: RankSettingViewModel by viewModel()

    override fun init() {
        binding.run {
            rankSet = this@RankSettingActivity
            rating = RatingManager
            vm = this@RankSettingActivity.viewModel

            rvExpert.adapter = RankLevelAdapter(RatingManager.EXPERT) { lv ->
                levelSelect(lv)
            }
            rvAdvanced.adapter = RankLevelAdapter(RatingManager.ADVANCED) { lv ->
                levelSelect(lv)
            }
            rvIntermediate.adapter = RankLevelAdapter(RatingManager.INTERMEDIATE) { lv ->
                levelSelect(lv)
            }
        }
    }

    /**
     * 타이틀 선택
     */
    fun titleSelect(type: String) {
        if (viewModel.rTitle.get() != type) {
            viewModel.rTitle.set(type)
        } else {
            viewModel.rTitle.set(null)
        }

        // BEGINNER 선택 시 종료
        if (type == RatingManager.BEGINNER) {
            finish()
        }
    }

    /**
     * 레벨 선택
     */
    private fun levelSelect(level: Int) {
        viewModel.rLevel.set(level)

        // 종료
        finish()
    }

    override fun finish() {
        setResult(RESULT_OK, Intent(this, MainActivity::class.java).apply {
            putExtra(KEY_TITLE, viewModel.rTitle.get())
            putExtra(KEY_LEVEL, viewModel.rLevel.get())
        })
        super.finish()
    }
}