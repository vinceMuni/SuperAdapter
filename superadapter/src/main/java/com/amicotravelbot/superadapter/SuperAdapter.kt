package com.amicotravelbot.superadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * SuperAdapter is an adapter created to avoid unused RecyclerView adapter and duplicated code.
 * List of [items] is defined with <*> type, so any object is accepted.
 * Any view can be inflated using [viewToInflate] reference.
 * An [onViewLoadedListener] needs to be defined to act directly to the loaded view.
 */
class SuperAdapter() : RecyclerView.Adapter<SuperAdapter.SuperViewHolder>() {

    companion object {
        fun create(items: ArrayList<*>, viewToInflate: Int, onViewLoadedListener: OnViewLoadedListener): SuperAdapter {
            return SuperAdapter(items, viewToInflate, onViewLoadedListener)
        }
    }

    private lateinit var items: ArrayList<*>
    private var viewToInflate: Int = 0
    private lateinit var onViewLoadedListener: OnViewLoadedListener

    private constructor(items: ArrayList<*>, viewToInflate: Int, onViewLoadedListener: OnViewLoadedListener): this(){
        this.items = items
        this.viewToInflate = viewToInflate
        this.onViewLoadedListener = onViewLoadedListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperViewHolder {
        return SuperViewHolder(LayoutInflater.from(parent.context).inflate(viewToInflate, parent,false), onViewLoadedListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SuperViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class SuperViewHolder(itemView: View, var onViewLoadedListener: OnViewLoadedListener): RecyclerView.ViewHolder(itemView) {

        fun bindItem(any: Any){
            onViewLoadedListener.onViewLoaded(itemView, any)
            itemView.setOnClickListener { onViewLoadedListener.onViewClicked(itemView, any) }
        }
    }

    interface OnViewLoadedListener {

        /**
         * @param itemView
         * @param any
         * It is called when the item view has been inflated and loaded
         */
        fun onViewLoaded(itemView: View, any: Any)

        /**
         * @param itemView
         * @param any
         * This is a generic method called when the item view has been clicked.
         * Any view-specific click listener can be defined inside [onViewLoaded].
         */
        fun onViewClicked(itemView: View, any: Any)
    }
}