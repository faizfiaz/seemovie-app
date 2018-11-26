package com.selfcompany.faizf.seemovie.presentation.fragment.slider

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.presentation.detailmovie.DetailMovieActivity
import com.selfcompany.faizf.seemovie.presentation.fragment.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_slider.*

/**
 * Created by faizf on 08/03/2018.
 */
class SliderFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        (activity?.applicationContext as SeeMovieApp).injector.inject(this)

        return inflater.inflate(R.layout.fragment_slider, container, false)
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Picasso.with(activity).load("https://image.tmdb.org/t/p/w1280" + (arguments?.getString("image"))).into(image)
        title.text = arguments?.getString("title")
        overview.text = arguments?.getString("overview")

        detail.setOnClickListener({detailMovie()})
    }

    fun detailMovie(){
        val intent = Intent(context, DetailMovieActivity::class.java)
        intent.putExtra("id", arguments?.getLong("id").toString())
        startActivity(intent)
    }
}