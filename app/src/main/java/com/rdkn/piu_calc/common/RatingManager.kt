package com.rdkn.piu_calc.common

import com.rdkn.piu_calc.data.Rating

object RatingManager {
    const val EXPERT = "EXPERT"
    const val ADVANCED = "ADVANCED"
    const val INTERMEDIATE = "INTERMEDIATE"
    const val BEGINNER = "BEGINNER"

    const val LEVEL_1 = 1
    const val LEVEL_2 = 2
    const val LEVEL_3 = 3
    const val LEVEL_4 = 4
    const val LEVEL_5 = 5
    const val LEVEL_6 = 6
    const val LEVEL_7 = 7
    const val LEVEL_8 = 8
    const val LEVEL_9 = 9
    const val LEVEL_10 = 10

    // P = Plus(+)
    const val GRADE_SSSP = "SSS+"
    const val GRADE_SSS = "SSS"
    const val GRADE_SSP = "SS+"
    const val GRADE_SS = "SS"
    const val GRADE_SP = "S+"
    const val GRADE_S = "S"
    const val GRADE_AAAP = "AAA+"
    const val GRADE_AAA = "AAA"
    const val GRADE_AAP = "AA+"
    const val GRADE_AA = "AA"
    const val GRADE_AP = "A+"
    const val GRADE_A = "A"

    // INTERMEDIATE
    val SCORE_MAP_INTERMEDIATE_LV_1 = hashMapOf(
        GRADE_SSSP to 150,
        GRADE_SSS to 144,
        GRADE_SSP to 138,
        GRADE_SS to 132,
        GRADE_SP to 126,
        GRADE_S to 120,
        GRADE_AAAP to 115,
        GRADE_AAA to 110,
        GRADE_AAP to 105,
        GRADE_AA to 100,
        GRADE_AP to 90,
        GRADE_A to 80
    )
    val SCORE_MAP_INTERMEDIATE_LV_2 = hashMapOf(
        GRADE_SSSP to 165,
        GRADE_SSS to 158,
        GRADE_SSP to 152,
        GRADE_SS to 145,
        GRADE_SP to 139,
        GRADE_S to 132,
        GRADE_AAAP to 127,
        GRADE_AAA to 121,
        GRADE_AAP to 116,
        GRADE_AA to 110,
        GRADE_AP to 99,
        GRADE_A to 88
    )
    val SCORE_MAP_INTERMEDIATE_LV_3 = hashMapOf(
        GRADE_SSSP to 195,
        GRADE_SSS to 187,
        GRADE_SSP to 179,
        GRADE_SS to 172,
        GRADE_SP to 164,
        GRADE_S to 156,
        GRADE_AAAP to 150,
        GRADE_AAA to 143,
        GRADE_AAP to 137,
        GRADE_AA to 130,
        GRADE_AP to 117,
        GRADE_A to 104
    )
    val SCORE_MAP_INTERMEDIATE_LV_4 = hashMapOf(
        GRADE_SSSP to 240,
        GRADE_SSS to 230,
        GRADE_SSP to 221,
        GRADE_SS to 211,
        GRADE_SP to 202,
        GRADE_S to 192,
        GRADE_AAAP to 184,
        GRADE_AAA to 173,
        GRADE_AAP to 168,
        GRADE_AA to 160,
        GRADE_AP to 144,
        GRADE_A to 128
    )
    val SCORE_MAP_INTERMEDIATE_LV_5 = hashMapOf(
        GRADE_SSSP to 300,
        GRADE_SSS to 288,
        GRADE_SSP to 276,
        GRADE_SS to 264,
        GRADE_SP to 252,
        GRADE_S to 240,
        GRADE_AAAP to 230,
        GRADE_AAA to 220,
        GRADE_AAP to 210,
        GRADE_AA to 200,
        GRADE_AP to 180,
        GRADE_A to 160
    )
    val SCORE_MAP_INTERMEDIATE_LV_6 = hashMapOf(
        GRADE_SSSP to 375,
        GRADE_SSS to 360,
        GRADE_SSP to 345,
        GRADE_SS to 330,
        GRADE_SP to 315,
        GRADE_S to 300,
        GRADE_AAAP to 288,
        GRADE_AAA to 275,
        GRADE_AAP to 263,
        GRADE_AA to 250,
        GRADE_AP to 225,
        GRADE_A to 200
    )
    val SCORE_MAP_INTERMEDIATE_LV_7 = hashMapOf(
        GRADE_SSSP to 465,
        GRADE_SSS to 446,
        GRADE_SSP to 428,
        GRADE_SS to 409,
        GRADE_SP to 391,
        GRADE_S to 372,
        GRADE_AAAP to 357,
        GRADE_AAA to 341,
        GRADE_AAP to 326,
        GRADE_AA to 310,
        GRADE_AP to 279,
        GRADE_A to 248
    )
    val SCORE_MAP_INTERMEDIATE_LV_8 = hashMapOf(
        GRADE_SSSP to 570,
        GRADE_SSS to 547,
        GRADE_SSP to 524,
        GRADE_SS to 502,
        GRADE_SP to 479,
        GRADE_S to 456,
        GRADE_AAAP to 437,
        GRADE_AAA to 418,
        GRADE_AAP to 399,
        GRADE_AA to 380,
        GRADE_AP to 342,
        GRADE_A to 304
    )
    val SCORE_MAP_INTERMEDIATE_LV_9 = hashMapOf(
        GRADE_SSSP to 690,
        GRADE_SSS to 662,
        GRADE_SSP to 635,
        GRADE_SS to 607,
        GRADE_SP to 580,
        GRADE_S to 552,
        GRADE_AAAP to 529,
        GRADE_AAA to 506,
        GRADE_AAP to 483,
        GRADE_AA to 460,
        GRADE_AP to 414,
        GRADE_A to 368
    )
    val SCORE_MAP_INTERMEDIATE_LV_10 = hashMapOf(
        GRADE_SSSP to 825,
        GRADE_SSS to 792,
        GRADE_SSP to 759,
        GRADE_SS to 726,
        GRADE_SP to 693,
        GRADE_S to 660,
        GRADE_AAAP to 633,
        GRADE_AAA to 605,
        GRADE_AAP to 578,
        GRADE_AA to 550,
        GRADE_AP to 495,
        GRADE_A to 440
    )

    // ADVANCED
    val SCORE_MAP_ADVANCED_LV_1 = hashMapOf(
        GRADE_SSSP to 975,
        GRADE_SSS to 936,
        GRADE_SSP to 897,
        GRADE_SS to 858,
        GRADE_SP to 819,
        GRADE_S to 780,
        GRADE_AAAP to 748,
        GRADE_AAA to 715,
        GRADE_AAP to 683,
        GRADE_AA to 650,
        GRADE_AP to 585,
        GRADE_A to 520
    )

    val RATING_MAP = hashMapOf(
        INTERMEDIATE to hashMapOf(
            LEVEL_1 to Rating(INTERMEDIATE, LEVEL_1, 10, 2000, SCORE_MAP_INTERMEDIATE_LV_1),
            LEVEL_2 to Rating(INTERMEDIATE, LEVEL_2, 11, 2200, SCORE_MAP_INTERMEDIATE_LV_2),
            LEVEL_3 to Rating(INTERMEDIATE, LEVEL_3, 12, 2600, SCORE_MAP_INTERMEDIATE_LV_3),
            LEVEL_4 to Rating(INTERMEDIATE, LEVEL_4, 13, 3200, SCORE_MAP_INTERMEDIATE_LV_4),
            LEVEL_5 to Rating(INTERMEDIATE, LEVEL_5, 14, 4000, SCORE_MAP_INTERMEDIATE_LV_5),
            LEVEL_6 to Rating(INTERMEDIATE, LEVEL_6, 15, 5000, SCORE_MAP_INTERMEDIATE_LV_6),
            LEVEL_7 to Rating(INTERMEDIATE, LEVEL_7, 16, 6200, SCORE_MAP_INTERMEDIATE_LV_7),
            LEVEL_8 to Rating(INTERMEDIATE, LEVEL_8, 17, 7600, SCORE_MAP_INTERMEDIATE_LV_8),
            LEVEL_9 to Rating(INTERMEDIATE, LEVEL_9, 18, 9200, SCORE_MAP_INTERMEDIATE_LV_9),
            LEVEL_10 to Rating(INTERMEDIATE, LEVEL_10, 19, 11000, SCORE_MAP_INTERMEDIATE_LV_10)
        )
    )

    val ARRAY_TITLE = arrayOf(
        EXPERT,
        ADVANCED,
        INTERMEDIATE,
        BEGINNER
    )

    val ARRAY_GRADE = arrayOf(
        GRADE_SSSP,
        GRADE_SSS,
        GRADE_SSP,
        GRADE_SS,
        GRADE_SP,
        GRADE_S,
        GRADE_AAAP,
        GRADE_AAA,
        GRADE_AAP,
        GRADE_AA,
        GRADE_AP,
        GRADE_A
    )
}