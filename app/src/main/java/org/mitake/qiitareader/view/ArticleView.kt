package org.mitake.qiitareader.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import org.mitake.qiitareader.R
import org.mitake.qiitareader.model.Article
import org.w3c.dom.Text

/**
 * Created by mitake on 2017/12/17.
 */

class ArticleView: FrameLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    val profileImageView: ImageView by lazy {
        findViewById<ImageView>(R.id.profile_image_view)
    }
    val titleTextView: TextView by lazy {
        findViewById<TextView>(R.id.title_text_view)
    }
    val userNameTextView: TextView by lazy {
        findViewById<TextView>(R.id.user_name_text_view)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_article, this)
    }

    fun setArticle(article: Article) {
        titleTextView.text = article.title
        userNameTextView.text = article.user.name

        // TODO プロフィール画像をセットする
    }
}