package com.selfcompany.faizf.seemovie.presentation.view.fragment

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.domain.model.NowPlayingItem
import com.selfcompany.faizf.seemovie.domain.model.PopularItem
import com.selfcompany.faizf.seemovie.domain.model.TopRatedItem
import com.selfcompany.faizf.seemovie.domain.model.UpcomingItem
import com.selfcompany.faizf.seemovie.presentation.presenter.callback.CallbackItemClicked
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.fragment.MoviePres
import com.selfcompany.faizf.seemovie.presentation.view.adapter.AdapterPopularMovie
import com.selfcompany.faizf.seemovie.presentation.view.adapter.AdapterTopRated
import com.selfcompany.faizf.seemovie.presentation.view.adapter.AdapterUpcoming
import com.selfcompany.faizf.seemovie.presentation.view.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_movie.*
import java.util.*
import javax.inject.Inject


/**
 * Created by faizf on 07/03/2018.
 */
class MovieFragment : BaseFragment(), CallbackItemClicked{

    @Inject lateinit var presenter : MoviePres

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        (activity?.applicationContext as SeeMovieApp).injector.inject(this)

        presenter.attachView(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getData()
    }

    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 500
    val PERIOD_MS: Long = 5000
    var handler : Handler? = null
    var Update : Runnable? = null

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun createSlider(data : MutableList<NowPlayingItem>){
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        data.take(5).forEach({
            val bundle = Bundle()
            bundle.putString("image", it.backdropPath)
            bundle.putString("title", it.title)
            bundle.putString("overview", it.overview)
            bundle.putLong("id", it.id)
            val sliderFragment = SliderFragment()
            sliderFragment.arguments = bundle
            viewPagerAdapter.addFragment(sliderFragment, "")
        })

        pager.adapter = viewPagerAdapter

        pager.layoutParams = activity?.let { util.setOneThirdLayout(it) }

        handler = Handler()
        Update = Runnable {
            if (currentPage == 5) {
                currentPage = 0
            }
            pager.setCurrentItem(currentPage++, true)
        }

        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler?.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)

    }

    override fun onStop() {
        timer?.cancel()
        handler?.removeCallbacks(Update)
        super.onStop()
    }

    override fun onDestroy() {
        timer?.cancel()
        handler?.removeCallbacks(Update)
        super.onDestroy()
    }


    fun createListPopular(data: MutableList<PopularItem>) {
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        popularMovieList?.layoutManager = linearLayoutManager
        linearLayoutManager.scrollToPosition(2)
        val adapter = activity?.applicationContext?.let { AdapterPopularMovie(data, it, this) }
        popularMovieList?.adapter = adapter
        popularMovieList.enableViewScaling(true)
    }

    fun createListTopRated(data: MutableList<TopRatedItem>) {
        topRatedList?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val adapter = activity?.applicationContext?.let { AdapterTopRated(data, it, this) }
        topRatedList?.adapter = adapter
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(topRatedList)

    }

    fun createListUpcoming(data: MutableList<UpcomingItem>) {
        upcomingList?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val adapter = activity?.applicationContext?.let { AdapterUpcoming(data, it, this) }
        upcomingList?.adapter = adapter
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(upcomingList)
    }

    override fun onClicked(any: Any) {
        presenter.goToDetail(any)
    }

}