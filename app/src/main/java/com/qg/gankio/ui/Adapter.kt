package com.qg.gankio.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mobile.utils.showToast
import com.qg.gankio.R
import com.qg.gankio.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

/**
 * Created by jimji on 2017/11/6.
 */
class Adapter(var datas: List<Article>, val ctx: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false))
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(datas[position]) {
//            if (imageUrls != null) {
//                Glide.with(ctx).load(imageUrls!![0]).into(holder.itemView.articleImage)
//            }
            holder.itemView.articleTitle.text = desc
        }

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)


}