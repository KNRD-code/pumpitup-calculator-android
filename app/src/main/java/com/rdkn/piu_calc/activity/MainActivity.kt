package com.rdkn.piu_calc.activity

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.rdkn.piu_calc.R
import com.rdkn.piu_calc.base.BaseActivity
import com.rdkn.piu_calc.common.RatingManager
import com.rdkn.piu_calc.data.UserInfo
import com.rdkn.piu_calc.databinding.ActivityMainBinding
import com.rdkn.piu_calc.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override var layoutRes: Int = R.layout.activity_main
    private val viewModel: MainViewModel by viewModel()

    private val rankSettingResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val uInfo = if (viewModel.userInfo.value == null) {
                UserInfo()
            } else {
                viewModel.userInfo.value
            }

            uInfo?.title = result.data?.getStringExtra(KEY_TITLE) ?: ""
            uInfo?.tLevel = result.data?.getIntExtra(KEY_LEVEL, 0) ?: 0
            viewModel.userInfo.value = uInfo
        }
    }
    private val scoreEditResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            viewModel.userInfo.value = result.data?.getSerializableExtra(KEY_USER_INFO) as? UserInfo
        }
    }

    override fun init() {
        binding.run {
            vm = viewModel

            btnSetting.setOnClickListener {
                rankSettingResult.launch(
                    Intent(this@MainActivity, RankSettingActivity::class.java)
                )
            }
            btnEdit.setOnClickListener {
                scoreEditResult.launch(
                    Intent(this@MainActivity, ScoreEditActivity::class.java).apply {
                        putExtra(KEY_USER_INFO, viewModel.userInfo.value)
                    }
                )
            }

            bnvMain.setupWithNavController(
                (supportFragmentManager.findFragmentById(R.id.fcv_container) as NavHostFragment).navController
            )
        }

        viewModel.run {
            userInfo.observe(this@MainActivity) {
                title.set(it.title)
                tLevel.set(it.tLevel)

                if (it.title == RatingManager.INTERMEDIATE) {
                    ratingInfo.set(RatingManager.RATING_MAP.getValue(it.title).getValue(it.tLevel))
                }
            }
        }
    }
}