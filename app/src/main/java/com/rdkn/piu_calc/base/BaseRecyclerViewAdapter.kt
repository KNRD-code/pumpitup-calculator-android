package net.quber.launcher.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<VB: ViewDataBinding>(val layoutRes: Int)
    : RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder<VB>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutRes,
                parent,
                false)
        )

    class ViewHolder<T: ViewDataBinding>(val bind: T) : RecyclerView.ViewHolder(bind.root)
}