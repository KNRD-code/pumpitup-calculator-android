package com.rdkn.piu_calc.activity

import android.content.Intent
import com.rdkn.piu_calc.R
import com.rdkn.piu_calc.adapter.GradeAdapter
import com.rdkn.piu_calc.base.BaseActivity
import com.rdkn.piu_calc.common.RatingManager
import com.rdkn.piu_calc.data.UserInfo
import com.rdkn.piu_calc.databinding.ActivityScoreEditBinding
import com.rdkn.piu_calc.viewmodel.ScoreEditViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScoreEditActivity : BaseActivity<ActivityScoreEditBinding>() {
    override var layoutRes: Int = R.layout.activity_score_edit
    private val viewModel: ScoreEditViewModel by viewModel()

    override fun init() {
        viewModel.run {
            userInfo.observe(this@ScoreEditActivity) {
                rankInfo.set(
                    RatingManager.RATING_MAP.getValue(it.title).getValue(it.tLevel)
                )
                curScore.set(it.tScore)
            }
            userInfo.value = intent.getSerializableExtra(KEY_USER_INFO) as? UserInfo
        }

        val countArr = viewModel.userInfo.value?.let {
            val arr = Array(12) { 0 }
            val countMap = it.rating.getValue(it.title).getValue(it.tLevel)
            RatingManager.ARRAY_GRADE.forEachIndexed { index, grade ->
                arr[index] = countMap.getValue(grade)
            }
            arr
        } ?: run {
            Array(12) { 0 }
        }
        binding.run {
            score = this@ScoreEditActivity
            vm = viewModel
            rvGrade.adapter = GradeAdapter(
                RatingManager.ARRAY_GRADE,
                countArr
            ) { grade, count ->
                viewModel.userInfo.value?.updateGradeCount(grade, count)
                viewModel.curScore.set(viewModel.userInfo.value?.tScore ?: 0)
            }
        }
    }

    override fun finish() {
        setResult(RESULT_OK, Intent(this, MainActivity::class.java).apply {
            putExtra(KEY_USER_INFO, viewModel.userInfo.value)
        })
        super.finish()
    }

}