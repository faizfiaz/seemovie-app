package com.selfcompany.faizf.seemovie.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.domain.model.UpcomingItem
import com.selfcompany.faizf.seemovie.presentation.presenter.callback.CallbackItemClicked
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_movie_upcoming.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by faizf on 10/03/2018.
 */
class AdapterUpcoming(private val list: MutableList<UpcomingItem>,
                      private val context: Context,
                      private val callbackItemClicked: CallbackItemClicked) : RecyclerView.Adapter<AdapterUpcoming.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItems(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.adapter_movie_upcoming, parent, false)
        return ViewHolder(v, callbackItemClicked)
    }


    class ViewHolder(itemView: View, private val callbackItemClicked: CallbackItemClicked) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        fun bindItems(items: UpcomingItem) {
            Picasso.with(itemView.context).load("https://image.tmdb.org/t/p/w500" + items.backdropPath).into(itemView.image)
            itemView.date.text = changeDate(items.releaseDate)
            itemView.tag = items.id

            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            callbackItemClicked.onClicked(itemView.tag)
        }

        val format = SimpleDateFormat("E MMM DD HH:mm:ss zzz yyyy")
        val formatWithTime = SimpleDateFormat("yyyy-MM-dd")
        val formatDate = SimpleDateFormat("dd-MMMM-yyyy", Locale("in"))


        fun changeDate(sDate: String?): String {
            var result = ""
            if (sDate != null) {
                try {
                    val date = formatWithTime.parse(sDate)
                    result = formatDate.format(date).replace("-".toRegex(), " ")
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

            }
            return result
        }

    }
}