package com.selfcompany.faizf.seemovie.presentation.seemore

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.implementor.presenter.callback.CallbackItemClicked
import com.selfcompany.faizf.seemovie.presentation.activity.BaseActivity
import com.selfcompany.faizf.seemovie.presentation.adapter.AdapterSeeMore
import kotlinx.android.synthetic.main.activity_see_more.*
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by faizf on 16/03/2018.
 */
class SeeMoreActivity : BaseActivity(), CallbackItemClicked {

    @Inject
    lateinit var presenter: SeeMorePres
    var isLoading by Delegates.notNull<Boolean>()
    val adapterSeeMore: AdapterSeeMore<Any>? = null
    var page: Int = 1
    var isFirst = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_more)

        (application as SeeMovieApp).injector.inject(this)
        isLoading = false
        presenter.attachView(this)
        presenter.getData(intent.getStringExtra("from"), page)
    }

    fun backActivity(view: View) {
        super.onBackPressed()
    }

    lateinit var layout: GridLayoutManager
    private lateinit var adapter: AdapterSeeMore<Any>
    fun setList(o: Any?) {
        val item = o as MutableList<Any>
        if (isFirst) {
            layout = GridLayoutManager(this, 2)
            list.layoutManager = layout
            layout.isAutoMeasureEnabled = false
            adapter = AdapterSeeMore(item, this)
            list.adapter = adapter
        } else {
            adapter.addData(item)
        }

        list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                val countItem = layout.itemCount
                val lastVisiblePosition = layout.findLastCompletelyVisibleItemPosition()
                val isLastPosition = countItem.minus(1) == lastVisiblePosition
                if (!isLoading && isLastPosition) {
                    presenter.getData(intent.getStringExtra("from"), ++page)
                    isFirst = false
                }
            }
        })
    }

    override fun onClicked(any: Any) {
        presenter.goDetail(any)
    }
}