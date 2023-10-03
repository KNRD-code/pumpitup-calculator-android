package com.rdkn.piu_calc.activity

import com.rdkn.piu_calc.R
import com.rdkn.piu_calc.base.BaseActivity
import com.rdkn.piu_calc.common.intentTo
import com.rdkn.piu_calc.databinding.ActivityLoginBinding

/**
 * 로그인
 * created by KANA (2023-10-03)
 */
class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override var layoutRes: Int = R.layout.activity_login

    override fun init() {
        binding.btnLogin.setOnClickListener {
            startActivity(intentTo(MainActivity::class.java))
            finish()
        }
    }
}