package com.selfcompany.faizf.seemovie.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.data.entity.movie.ResultMovie
import com.selfcompany.faizf.seemovie.presentation.presenter.callback.CallbackTrailer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_trailer.view.*

/**
 * Created by faizf on 16/03/2018.
 */
class AdapterTrailer (private val list: List<ResultMovie>,
                      private val context: Context,
                      private val callbackTrailer: CallbackTrailer) : RecyclerView.Adapter<AdapterTrailer.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItems(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.adapter_trailer, parent, false)
        return ViewHolder(v, callbackTrailer)
    }


    class ViewHolder(itemView: View, private val callbackTrailer: CallbackTrailer) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        fun bindItems(items: ResultMovie) {
            Picasso.with(itemView.context).load("https://img.youtube.com/vi/${items.key}/hqdefault.jpg").into(itemView.image)

            itemView.tag = items.key
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            callbackTrailer.onClicked(itemView.tag.toString())
        }

    }
}