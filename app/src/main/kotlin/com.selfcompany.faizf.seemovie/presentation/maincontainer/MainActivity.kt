package com.selfcompany.faizf.seemovie.presentation.maincontainer

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.presentation.activity.BaseActivity
import com.selfcompany.faizf.seemovie.presentation.adapter.AdapterPagerTab
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private val tabTitles = arrayOf("Movies", "Cinemas", "Account")
    private val imageResId = intArrayOf(R.drawable.ic_movies, R.drawable.ic_cinema, R.drawable.ic_user)

    @Inject lateinit var presenter : MainPres

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as SeeMovieApp).injector.inject(this)
        
        setTab()
        presenter.attachView(this)
    }

    private fun setTab() {
        pager.adapter = AdapterPagerTab(supportFragmentManager, presenter.listTab()!!, this)
        tab.setupWithViewPager(pager)
        pager.offscreenPageLimit = 4
        setTabIcon(tab)
    }

    private fun setTabIcon(tab: TabLayout?) {
        for (pos in 0 until presenter.listTab()!!.size) {
            val t = tab?.getTabAt(pos)
            t!!.customView = getTabView(pos)
            tab.getTabAt(pos)!!.setIcon(presenter.getListTab()!![pos].imageId)
        }
    }

    private fun getTabView(position: Int): View {
        val v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        val tv = v.findViewById<TextView>(R.id.text)
        tv.text = tabTitles[position]
        val img = v.findViewById<ImageView>(R.id.image)
        img.setImageResource(imageResId[position])
        return v
    }


}
