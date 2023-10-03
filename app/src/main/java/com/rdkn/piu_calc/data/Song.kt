package com.rdkn.piu_calc.data

import java.io.Serializable

/**
 * {File Description}
 * created by KANA (2023-10-03)
 */
data class Song(
    val idx: Int = -1,
    val nameKor: String = "-",
    val nameEnd: String = "-",
    val artistKor: String = "-",
    val artistEnd: String = "-",
    val thumbnail: String? = null,
    val sIdx: String = "",
    val bpm: String = "-"
) : Serializable