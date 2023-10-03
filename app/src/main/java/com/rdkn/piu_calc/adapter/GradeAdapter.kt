package com.rdkn.piu_calc.adapter

import android.text.Editable
import android.text.TextWatcher
import com.rdkn.piu_calc.R
import com.rdkn.piu_calc.databinding.ItemGradeBinding
import net.quber.launcher.base.BaseRecyclerViewAdapter

class GradeAdapter(
    private val gradeArr: Array<String>,
    private val countArr: Array<Int>,
    val clickAction: (grade: String, count: Int) -> Unit
) : BaseRecyclerViewAdapter<ItemGradeBinding>(R.layout.item_grade) {
    val gradeSortApp = Array(12) { "" }

    init {
        for (i in 0..11) {
            if (i % 2 == 0) {
                gradeSortApp[i/2] = gradeArr[i]
            } else {

            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder<ItemGradeBinding>, position: Int) {
        val pos = holder.adapterPosition
        with (holder.bind) {
            grade = gradeArr[position]
            count = countArr[position]

            ibPlus.setOnClickListener {
                countArr[pos] = countArr[pos] + 1
                etCount.setText(countArr[pos].toString())
            }
            ibMinus.setOnClickListener {
                if (countArr[pos] > 0) {
                    countArr[pos] = countArr[pos] - 1
                    etCount.setText(countArr[pos].toString())
                }
            }
            etCount.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    p0?.let {
                        clickAction.invoke(gradeArr[pos], countArr[pos])
                    }
                }
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {}
            })
        }
    }

    override fun getItemCount(): Int = 12
}