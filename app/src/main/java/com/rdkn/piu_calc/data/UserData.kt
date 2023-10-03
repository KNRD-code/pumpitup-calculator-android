package com.rdkn.piu_calc.data

import java.io.Serializable

/**
 * 유저 정보
 * created by KANA (2023-10-03)
 */
data class UserData(
    val idx: Int = -1,
    val nickname: String = "",
    val code: String = "",
    val tIdx: Int = -1
) : Serializable