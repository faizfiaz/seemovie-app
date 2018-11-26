package com.selfcompany.faizf.seemovie.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selfcompany.faizf.newbase.entity.movie.MovieEntity
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.implementor.presenter.callback.CallbackItemClicked
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_movie_popular.view.*

/**
 * Created by faizf on 16/03/2018.
 */
class AdapterRecommendation (private val list: List<MovieEntity>,
                             private val context: Context,
                             private val callbackItemClicked: CallbackItemClicked) : RecyclerView.Adapter<AdapterRecommendation.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindItems(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.adapter_movie_popular, parent, false)
        return ViewHolder(v, callbackItemClicked)
    }


    class ViewHolder(itemView: View, private val callbackItemClicked: CallbackItemClicked) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        fun bindItems(items: MovieEntity) {
            Picasso.with(itemView.context).load("https://image.tmdb.org/t/p/w500" + items.poster_path).into(itemView.image)
            itemView.tag = items.id
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            callbackItemClicked.onClicked(itemView.tag)
        }

    }
}