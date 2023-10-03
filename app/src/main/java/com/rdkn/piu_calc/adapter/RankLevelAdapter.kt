package com.rdkn.piu_calc.adapter

import com.rdkn.piu_calc.R
import com.rdkn.piu_calc.databinding.ItemRankLevelBinding
import net.quber.launcher.base.BaseRecyclerViewAdapter

class RankLevelAdapter(
    private val rank: String,
    private val clickAction: (lv: Int) -> Unit
) : BaseRecyclerViewAdapter<ItemRankLevelBinding>(R.layout.item_rank_level) {
    override fun onBindViewHolder(holder: ViewHolder<ItemRankLevelBinding>, position: Int) {
        with (holder) {
            bind.rank = this@RankLevelAdapter.rank
            bind.level = position + 1

            itemView.setOnClickListener {
                clickAction.invoke(position + 1)
            }
        }
    }

    override fun getItemCount(): Int = 10
}