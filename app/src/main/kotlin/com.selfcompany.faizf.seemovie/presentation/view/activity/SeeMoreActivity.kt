package com.selfcompany.faizf.seemovie.presentation.view.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.presentation.presenter.callback.CallbackItemClicked
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity.SeeMorePres
import com.selfcompany.faizf.seemovie.presentation.view.adapter.AdapterSeeMore
import kotlinx.android.synthetic.main.activity_see_more.*
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class SeeMoreActivity : BaseActivity(), CallbackItemClicked {

    @Inject lateinit var presenter: SeeMorePres

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_more)

        (application as SeeMovieApp).injector.inject(this)

        presenter.attachView(this)
        presenter.getData(intent.getStringExtra("from"))
    }

    fun backActivity(view: View){
        super.onBackPressed()
    }

    fun setList(o: Any?) {
        val layout = GridLayoutManager(this, 2)
        list.layoutManager = layout
        layout.isAutoMeasureEnabled = false
        list.adapter = AdapterSeeMore(o as MutableList<*>, this, this)
    }

    override fun onClicked(any: Any) {
        presenter.goDetail(any)
    }
}