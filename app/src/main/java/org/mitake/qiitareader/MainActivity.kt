package org.mitake.qiitareader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import org.mitake.qiitareader.model.Article
import org.mitake.qiitareader.model.User
import org.mitake.qiitareader.view.ArticleView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter = ArticleListAdapter(applicationContext)
        listAdapter.articles = listOf(
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa"),
                dummyArticle("タイトル", "みたけ"),
                dummyArticle("記事２", "aaaaaaa")
        )
        val listView: ListView = findViewById<ListView>(R.id.list_View)
        listView.adapter = listAdapter

        listView.setOnItemClickListener { adapterView, view, position, id ->
            val article = listAdapter.articles[position]
            ArticleActivity.intent(this, article).let { startActivity(it) }
        }
    }


    private fun dummyArticle(title: String, userName: String): Article =
        Article(id = "", title = title, url = "https://kotlinlang.org/", user = User(id = "", name = userName, profileImageUri = ""))
}
