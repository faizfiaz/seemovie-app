package com.selfcompany.faizf.seemovie.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.domain.model.TopRatedItem
import com.selfcompany.faizf.seemovie.implementor.presenter.callback.CallbackItemClicked
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_movie_top_rated.view.*

/**
 * Created by faizf on 09/03/2018.
 */
class AdapterTopRated(private val list: MutableList<TopRatedItem>,
                      private val context: Context,
                      private val callbackItemClicked: CallbackItemClicked) : RecyclerView.Adapter<AdapterTopRated.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindItems(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.adapter_movie_top_rated, parent, false)
        return ViewHolder(v, callbackItemClicked)
    }


    class ViewHolder(itemView: View, private val callbackItemClicked: CallbackItemClicked) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        fun bindItems(items: TopRatedItem) {
            Picasso.with(itemView.context).load("https://image.tmdb.org/t/p/w500" + items.backdropPath).into(itemView.image)
            itemView.title.text = items.title
            itemView.year.text = items.releaseDate.subSequence(0, 4)
            itemView.rate.text = items.voteAverage.toString()
            itemView.rating.rating = ((items.voteAverage * 5) /10).toFloat()
            itemView.votes.text = items.voteCount.toString() + " VOTES"

            itemView.tag = items.id
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            callbackItemClicked.onClicked(itemView.tag)
        }

    }
}