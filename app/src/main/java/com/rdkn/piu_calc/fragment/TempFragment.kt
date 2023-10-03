package com.rdkn.piu_calc.fragment

import com.rdkn.piu_calc.R
import com.rdkn.piu_calc.adapter.GradeAdapter
import com.rdkn.piu_calc.base.BaseFragment
import com.rdkn.piu_calc.common.RatingManager
import com.rdkn.piu_calc.databinding.FragmentTempBinding
import com.rdkn.piu_calc.viewmodel.ScoreEditViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 이전에 작성해놓은 코드들 저장용...
 * created by KANA (2023-10-03)
 */
class TempFragment : BaseFragment<FragmentTempBinding>() {
    override var layoutRes: Int = R.layout.fragment_temp
    private val viewModel: ScoreEditViewModel by viewModel()

    override fun init() {
        viewModel.run {
            userInfo.observe(viewLifecycleOwner) {
                rankInfo.set(
                    RatingManager.RATING_MAP.getValue(it.title).getValue(it.tLevel)
                )
                curScore.set(it.tScore)
            }
//            userInfo.value = intent.getSerializableExtra(BaseActivity.KEY_USER_INFO) as? UserInfo
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
}