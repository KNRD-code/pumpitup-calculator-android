package net.quber.launcher.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<VB: ViewDataBinding, D: Any>(diffCallback: DiffUtil.ItemCallback<D>)
    : ListAdapter<D, BaseListAdapter.ViewHolder<VB>>(diffCallback) {
    abstract var layoutRes: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutRes,
                parent,
                false
            )
        )
    }

    class ViewHolder<T: ViewDataBinding>(val bind: T) : RecyclerView.ViewHolder(bind.root)
}