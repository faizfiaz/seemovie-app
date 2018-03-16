package com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.presentation.model.content.ContentTab
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.BasePresenter
import com.selfcompany.faizf.seemovie.presentation.view.activity.MainActivity
import com.selfcompany.faizf.seemovie.presentation.view.fragment.AccountFragment
import com.selfcompany.faizf.seemovie.presentation.view.fragment.CinemasFragment
import com.selfcompany.faizf.seemovie.presentation.view.fragment.MovieFragment
import javax.inject.Inject


/**
 * Created by faizf on 07/03/2018.
 */
class MainPres @Inject constructor(private val context: Context) : BasePresenter<MainActivity>() {

    var contentTabs: ArrayList<ContentTab>? = null

    init {
        (context as SeeMovieApp).injector.inject(this)
    }

    fun listTab(): ArrayList<ContentTab>? {
        contentTabs = java.util.ArrayList()
        contentTabs!!.add(makeTab(MovieFragment() , "Movies", R.drawable.ic_user))
        contentTabs!!.add(makeTab(CinemasFragment(), "Cinemas", R.drawable.ic_user))
        contentTabs!!.add(makeTab(AccountFragment(), "Account", R.drawable.ic_user))
        this.contentTabs = contentTabs
        return contentTabs
    }

    fun getListTab(): ArrayList<ContentTab>? {
        return contentTabs
    }

    protected fun makeTab(fragment: Fragment, title: String, imageId: Int): ContentTab {
        return ContentTab().setFragment(fragment).setImageId(imageId).setTitle(title)
    }

    override fun create(saveState: Bundle) {

    }

    override fun resume() {

    }

    override fun pause() {
    }

    override fun destroy() {
    }

    override fun saveState(outState: Bundle) {

    }

}