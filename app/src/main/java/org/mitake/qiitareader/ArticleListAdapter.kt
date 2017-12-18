package org.mitake.qiitareader

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.mitake.qiitareader.model.Article
import org.mitake.qiitareader.view.ArticleView

/**
 * Created by mitake on 2017/12/17.
 */

class ArticleListAdapter(private val context: Context): BaseAdapter() {
    var articles: List<Article> = emptyList()

    override fun getItem(p0: Int): Any? = articles[p0]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = articles.count()

    override fun getView(positoin: Int, convertView: View?, parent: ViewGroup?): View =
        ((convertView as? ArticleView) ?: ArticleView(context)).apply {
            setArticle(articles[positoin])
        }
}