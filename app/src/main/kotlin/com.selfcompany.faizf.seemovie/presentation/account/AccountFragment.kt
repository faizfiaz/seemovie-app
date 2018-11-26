package com.selfcompany.faizf.seemovie.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.presentation.fragment.BaseFragment

/**
 * Created by faizf on 08/03/2018.
 */
class AccountFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        (activity?.applicationContext as SeeMovieApp).injector.inject(this)

        return inflater.inflate(R.layout.underconstruction, container, false)
    }
}