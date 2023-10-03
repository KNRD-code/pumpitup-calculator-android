package com.rdkn.piu_calc.data

import com.rdkn.piu_calc.common.RatingManager
import java.io.Serializable

data class UserInfo(
    var title: String = "",
    var tLevel: Int = 0,
    var tScore: Int = 0,
    var rating: HashMap<String, HashMap<Int, HashMap<String, Int>>> = hashMapOf() // <TITLE, <LEVEL, <GRADE, COUNT>>>
) : Serializable {

    init {
        RatingManager.ARRAY_TITLE.forEach { title ->
            rating[title] = hashMapOf()
            for (i in 1..10) { // level
                rating.getValue(title)[i] = hashMapOf()
                RatingManager.ARRAY_GRADE.forEach { grade ->
                    rating.getValue(title).getValue(i)[grade] = 0
                }
            }
        }
    }

    fun updateGradeCount(grade: String, count: Int) {
        rating.getValue(title).getValue(tLevel)[grade] = count
        updateTScore()
    }

    fun updateTScore() {
        var scoreSum = 0
        rating.getValue(title).getValue(tLevel).forEach { (grade, count) ->
            scoreSum += RatingManager.RATING_MAP.getValue(title).getValue(tLevel).scoreMap.getValue(grade) * count
        }
        tScore = scoreSum
    }

}