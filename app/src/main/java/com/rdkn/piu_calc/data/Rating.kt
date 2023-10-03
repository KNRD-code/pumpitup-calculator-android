package com.rdkn.piu_calc.data

import com.rdkn.piu_calc.common.RatingManager
import java.io.Serializable

data class Rating(
    val title: String = RatingManager.BEGINNER,      // 칭호 타이틀, E: EXPERT, A: ADVANCED, I: INTERMEDIATE, B: BEGINNER
    val tLevel: Int = RatingManager.LEVEL_1,         // 칭호 레벨, 1 ~ 10
    val sLevel: Int = 10,                           // 곡레벨, 10 ~ 27
    val targetScore: Int = 0,                       // 칭호 목표 스코어
    val scoreMap: Map<String, Int> = mapOf()        // 칭호 + 레벨에 따른 점수판
) : Serializable