package com.rdkn.piu_calc.common

import android.view.View
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.rdkn.piu_calc.R


@BindingAdapter("isSelected")
fun isSelected(view: View, isSelected: Boolean?) {
    isSelected?.let {
        view.isSelected = it
    }
}

@BindingAdapter("isVisible")
fun isVisible(view: View, isVisible: Boolean?) {
    isVisible?.let {
        view.isVisible = it
    }
}

@BindingAdapter("isInvisible")
fun isInvisible(view: View, isInvisible: Boolean?) {
    isInvisible?.let {
        view.isInvisible = it
    }
}

@BindingAdapter(
    "setRankLevelText_rank",
    "setRankLevelText_level")
fun setRankLevelText(view: TextView, rank: String?, level: Int?) {
    if (!rank.isNullOrBlank() && level != null) {
        view.text = when (rank) {
            RatingManager.EXPERT, RatingManager.ADVANCED, RatingManager.INTERMEDIATE -> {
                String.format(view.context.getString(R.string.rank_level_format), rank, level)
            }
            else -> RatingManager.BEGINNER
        }
    }
}