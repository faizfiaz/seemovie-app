package com.selfcompany.faizf.seemovie.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.domain.model.PopularItem
import com.selfcompany.faizf.seemovie.domain.model.TopRatedItem
import com.selfcompany.faizf.seemovie.domain.model.UpcomingItem
import com.selfcompany.faizf.seemovie.presentation.presenter.callback.CallbackItemClicked
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_see_more.view.*

/**
 * Created by faizf on 16/03/2018.
 */
class AdapterSeeMore<T>(private var list: MutableList<T>,
                        private val callbackItemClicked: CallbackItemClicked) : RecyclerView.Adapter<AdapterSeeMore.ViewHolder>() {


    companion object {
        val ITEM_VIEW_TYPE_CONTENT = 1
        val ITEM_VIEW_TYPE_LOADING = 2
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.bindItems(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        if (viewType == ITEM_VIEW_TYPE_CONTENT || viewType == 0) {
            val v = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_see_more, parent, false)
            return ViewHolder(v, callbackItemClicked)
        }else{
            val v = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_load_more, parent, false)
            return ViewHolderLoading(v)
        }
    }


    class ViewHolderLoading(itemView: View) : ViewHolder(itemView, null)


    open class ViewHolder(itemView: View, private val callbackItemClicked: CallbackItemClicked?) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        fun bindItems(items: Any?) {
            if (items is PopularItem) {
                setData(items.posterPath, items.id)
            } else if (items is UpcomingItem) {
                setData(items.posterPath, items.id)
            } else {
                items as TopRatedItem
                setData(items.posterPath, items.id)
            }

            itemView.setOnClickListener(this)
        }

        private fun setData(posterPath: String, id: Long) {
            Picasso.with(itemView.context).load("https://image.tmdb.org/t/p/w500$posterPath").into(itemView.image)
            itemView.tag = id
        }

        override fun onClick(p0: View?) {
            callbackItemClicked?.onClicked(itemView.tag)
        }

    }

    fun addData(item: MutableList<T>) {
        val oldSize = list.size
        list.addAll(item)
//        notifyItemInserted(list.size)
        notifyItemRangeChanged(oldSize, item.size)
    }
}