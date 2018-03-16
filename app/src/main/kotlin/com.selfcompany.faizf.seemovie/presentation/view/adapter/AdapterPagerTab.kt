package com.selfcompany.faizf.seemovie.presentation.view.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.selfcompany.faizf.seemovie.presentation.model.content.ContentTab
import java.util.*

class AdapterPagerTab(fm: FragmentManager, private val modelTabs: ArrayList<ContentTab>, private val context: Context) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return modelTabs[position].fragment
    }

    override fun getCount(): Int {
        return modelTabs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return modelTabs[position].title
    }
}
