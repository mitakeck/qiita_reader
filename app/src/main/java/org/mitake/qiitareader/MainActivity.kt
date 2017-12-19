package org.mitake.qiitareader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import org.mitake.qiitareader.client.ArticleClient
import org.mitake.qiitareader.model.Article
import org.mitake.qiitareader.model.User
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter = ArticleListAdapter(applicationContext)
        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://qiita.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        val articleClient = retrofit.create(ArticleClient::class.java)

        val queryEditText = findViewById<EditText>(R.id.query_edit_text)
        val searchButton = findViewById<Button>(R.id.search_button)

        searchButton.setOnClickListener {
            articleClient.search(queryEditText.text.toString())
                    .subscribeOn(rx.schedulers.Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread() as rx.Scheduler)
                    .subscribe({
                        queryEditText.text.clear()
                        listAdapter.articles = it
                        listAdapter.notifyDataSetChanged()
                    }, {
                        Toast.makeText(this, "error : $it", Toast.LENGTH_SHORT).show()
                    })
        }

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
