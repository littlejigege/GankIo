package com.qg.gankio.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.mobile.utils.EasyAdapter
import com.mobile.utils.inUiThread
import com.mobile.utils.showToast
import com.qg.gankio.App
import com.qg.gankio.R
import com.qg.gankio.model.Article
import com.qg.gankio.model.Feedback
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_today.*
import kotlinx.android.synthetic.main.item_article.view.*
import java.util.*

class TodayActivity : AppCompatActivity() {
    val app by lazy { application as App }
    lateinit var list: List<Article>
    lateinit var adapter: EasyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today)
        initView()
        getTodayList {
            list = it.data.androidList
            adapter.addData(list)
        }
    }


    private fun getTodayList(action: (Feedback) -> Unit) {
        val today = Calendar.getInstance()
        app.apiService.getOneDayList(today.get(Calendar.YEAR), today.get(Calendar.MONTH) + 1,
                today.get(Calendar.DATE))
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<Feedback> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: Feedback) {
                        inUiThread { action(value) }
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })


    }

    private fun initView() {
        adapter = EasyAdapter()
        adapter.addConfig(EasyAdapter.ItemConfig(Article::class, 1) {
            layId = R.layout.item_article
            onBindData { data, holder ->
                with(data as Article) {
                    if (imageUrls != null) {
                        Glide.with(this@TodayActivity).load(imageUrls!![0]).into(holder.itemView.articleImage)
                    }
                    holder.itemView.articleTitle.text = desc
                    println(data)
                }
            }
            onClick { data, pos -> showToast("666") }
        })
        todayList.layoutManager = LinearLayoutManager(this)
        todayList.adapter = adapter
    }
}
