package com.rdkn.piu_calc.common

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.util.DisplayMetrics
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Create Intent
 */
fun Context.intentTo(target: Class<*>): Intent =
    Intent(this, target)

/**
 * Px to Dp
 */
fun Number.toDp(): Int {
    val metrics = Resources.getSystem().displayMetrics
    return (this.toFloat() / ((metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))).toInt()
}

/**
 * Dp to Px
 */
fun Number.toPx(): Int {
    val metrics = Resources.getSystem().displayMetrics
    return (this.toFloat() * ((metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))).toInt()
}

/**
 * Any -> Json String
 */
inline fun <reified T: Any?> T.toJson(): String = Gson().toJson(this)

/**
 * String -> Any
 */
inline fun <reified T: Any> String.fromJson(): T? = try {
    Gson().fromJson(this, T::class.java)
} catch (e: Exception) {
    null
}

/**
 * String -> List<Any>
 */
inline fun <reified T: Any> String.fromJsonToList(): List<T> = try {
    Gson().fromJson(this, object : TypeToken<List<T>>(){}.type)
} catch (e: Exception) {
    arrayListOf()
}

/**
 * toJson() 후에 Array 관련 Char 삭제
 */
fun String.toCleanString(): String = this
    .replace("[","")
    .replace("]", "")
    .replace("\"", "")
    .replace("\\", "")

/**
 * Multiple Null Value Check
 */
inline fun <T: Any, R: Any> letAll(vararg parameters: T?, block: (List<T>) -> R): R? {
    return if (parameters.all { it != null }) {
        block.invoke(parameters.filterNotNull())
    } else {
        null
    }
}

/**
 * ObservableArrayList connect to Adapter notify
 */
inline fun <reified T: Any> ObservableArrayList<T>.connectToAdapter(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?) {
    adapter?.let {
        addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableArrayList<T>>() {
            override fun onChanged(sender: ObservableArrayList<T>?) {}
            override fun onItemRangeChanged(
                sender: ObservableArrayList<T>?,
                positionStart: Int,
                itemCount: Int
            ) {
                it.notifyItemRangeChanged(positionStart, itemCount)
            }
            override fun onItemRangeInserted(
                sender: ObservableArrayList<T>?,
                positionStart: Int,
                itemCount: Int
            ) {
                it.notifyItemRangeInserted(positionStart, itemCount)
            }
            override fun onItemRangeMoved(
                sender: ObservableArrayList<T>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {
                it.notifyItemMoved(fromPosition, toPosition)
            }
            override fun onItemRangeRemoved(
                sender: ObservableArrayList<T>?,
                positionStart: Int,
                itemCount: Int
            ) {
                it.notifyItemRangeRemoved(positionStart, itemCount)
            }
        })
    }
}