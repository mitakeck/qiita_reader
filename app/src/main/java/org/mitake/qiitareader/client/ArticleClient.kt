package org.mitake.qiitareader.client

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable
import org.mitake.qiitareader.model.Article

/**
 * Created by mitake on 2017/12/19.
 */

interface ArticleClient {
    @GET("/api/v2/items")
    fun search(@Query("query") query: String): Observable<List<Article>>
}